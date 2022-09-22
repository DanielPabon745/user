package com.example.users.users.service;

import com.example.users.users.exception.CustomException;
import com.example.users.users.exception.ErrorMessage;
import com.example.users.users.model.DocumentType;
import com.example.users.users.model.Person;
import com.example.users.users.util.PersonHelper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final Person person;

    public UserService() {
        this.person = PersonHelper.createPerson();
    }

    public Person getPerson(DocumentType documentType, String id) {
        if (Objects.isNull(documentType) || Strings.isBlank(id)) {
            throw new CustomException(ErrorMessage.BAD_REQUEST_MESSAGE);
        }
        if ((!this.person.getDocumentType().equals(documentType)) || (!this.person.getId().equals(id))) {
            throw new CustomException(ErrorMessage.NOT_FOUND_MESSAGE);
        }
        return this.person;
    }
}
