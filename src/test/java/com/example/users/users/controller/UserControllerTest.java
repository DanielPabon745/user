package com.example.users.users.controller;

import com.example.users.users.exception.CustomException;
import com.example.users.users.model.Person;
import com.example.users.users.service.UserService;
import com.example.users.users.util.PersonHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    private MockMvc mvc;

    @Test
    void test_get_person_by_document_and_id_successfully() throws Exception {
        Person person = PersonHelper.createPerson();
        Mockito.when(userService.getPerson(Mockito.any(), Mockito.anyString()))
                .thenReturn(person);

        mvc.perform(MockMvcRequestBuilders.get("/users")
                        .queryParam("documentType", "C")
                        .queryParam("id", "1232131231")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value(person.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.second_name").value(person.getSecondName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.first_lastname").value(person.getFirstLastname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.second_lastname").value(person.getSecondLastname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value(person.getAddress()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value(person.getCity()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone_number").value(person.getPhoneNumber()))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void test_get_person_by_document_and_id_bad_request() throws Exception {
        Mockito.when(userService.getPerson(Mockito.any(), Mockito.anyString()))
                .thenThrow(CustomException.class);

        mvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }
}