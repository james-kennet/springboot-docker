package com.app.person.controller;
import com.app.person.dto.request.PersonRequest;
import com.app.person.entity.Person;
import com.app.person.service.PersonService;
import com.app.person.validator.PersonRequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/person/")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRequestValidator validator;

    @GetMapping("hello")
    public String helloWorld(){
        String message = "Hello James, it is now " + new Timestamp(System.currentTimeMillis());
        LOGGER.info("helloWorld /hello called with message " + message);
        return message;
    }

    @GetMapping("all")
    public ResponseEntity<List<Person>> fetchAllPersons(){
        LOGGER.info("fetchAllPersons /all called.");
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @PostMapping("all/columnsort")
    public ResponseEntity<List<Person>> fetchAllPersons(@RequestBody PersonRequest personRequest){
        LOGGER.info("fetchAllPersons /all/columnsort called.");
        validator.validateColumn(personRequest.getColumn());
        return new ResponseEntity<>(personService.getAllPersonsSorted(personRequest), HttpStatus.OK);
    }
}
