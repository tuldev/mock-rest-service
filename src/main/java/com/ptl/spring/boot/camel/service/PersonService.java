package com.ptl.spring.boot.camel.service;

import com.ptl.spring.boot.camel.dto.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();
    Person getPerson(Integer personId);
    Person addPersons(Person personDTO);
}
