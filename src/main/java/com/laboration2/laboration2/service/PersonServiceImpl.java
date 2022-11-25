package com.laboration2.laboration2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboration2.laboration2.entity.Person;
import com.laboration2.laboration2.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getPersons() {
        return (List<Person>)personRepository.findAll();
    }
}
