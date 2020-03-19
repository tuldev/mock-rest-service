package com.ptl.spring.boot.camel.service;

import com.ptl.spring.boot.camel.dto.Person;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private List<Person> persons = new ArrayList<>();


    @PostConstruct
    public void init() {
        persons.add(new Person(1, "Amar"));
        persons.add(new Person(2, "David"));
        persons.add(new Person(3, "Jack"));
        persons.add(new Person(4, "Ravi"));
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public Person getPerson(Integer personId) {
        Person personDTO =  persons.stream()
                .filter(p -> p.getId().intValue() == personId.intValue())
                .findAny().get();

        return personDTO;
    }

    @Override
    public Person addPersons(Person personDTO) {
        persons.add(personDTO);
        return personDTO;
    }
}
