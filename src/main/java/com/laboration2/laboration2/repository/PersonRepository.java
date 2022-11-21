package com.laboration2.laboration2.repository;

import org.springframework.data.repository.CrudRepository;

import com.laboration2.laboration2.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
