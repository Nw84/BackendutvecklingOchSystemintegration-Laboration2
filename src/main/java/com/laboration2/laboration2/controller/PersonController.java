package com.laboration2.laboration2.controller;

import java.net.URI;

import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laboration2.laboration2.entity.Person;
import com.laboration2.laboration2.repository.CarRepository;
import com.laboration2.laboration2.repository.PersonRepository;

@RestController
public class PersonController {

    CarRepository carRepository;
    PersonRepository personRepository;

    public PersonController(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository; 
    }


    @GetMapping("/person/{id}")
     public ResponseEntity<Person> getOne(@PathVariable("id") Long id) {
        var person = personRepository.findById(id);

        if (person.isPresent()) {
            Hibernate.initialize(person.get().getName());
            return ResponseEntity.ok().body(person.get());
        }
        return ResponseEntity.notFound().build();
     }

     @PostMapping("/person")
     public ResponseEntity<Person> createPerson(@RequestBody Person person) {

        var myPerson = personRepository.save(person);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(myPerson.getId())
                        .toUri();


        return ResponseEntity.created(location).body(myPerson);
     }

}
