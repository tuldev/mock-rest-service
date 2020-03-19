package com.ptl.spring.boot.camel.controller;

import com.ptl.spring.boot.camel.dto.Person;
import com.ptl.spring.boot.camel.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Person>> getPersons() {
        log.info("get all persons");
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @GetMapping(value = "/{personId}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Person> getPersonById(@PathVariable Integer personId) {
        log.info("get person by Id");
        return new ResponseEntity<>(personService.getPerson(personId), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        log.info("add person details: {}", person);
        personService.addPersons(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

}
