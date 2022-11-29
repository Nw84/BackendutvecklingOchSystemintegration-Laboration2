package com.laboration2.laboration2.service;

import java.util.List;

import com.laboration2.laboration2.entity.Person;

public interface PersonService {
    Person getPerson(Long id);
    Person savePerson(Person person);
    void deletePerson(Long id);
    List<Person> getPersons();
}
