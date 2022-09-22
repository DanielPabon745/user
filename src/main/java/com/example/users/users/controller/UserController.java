package com.example.users.users.controller;

import com.example.users.users.model.DocumentType;
import com.example.users.users.model.Person;
import com.example.users.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Person> getPersonByDocumentAndId(
            @RequestParam DocumentType documentType,
            @RequestParam String id) {
        return ResponseEntity.ok(userService.getPerson(documentType, id));

    }
}
