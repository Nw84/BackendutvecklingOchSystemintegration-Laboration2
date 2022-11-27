package com.laboration2.laboration2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboration2.laboration2.entity.Car;
import com.laboration2.laboration2.entity.Person;
import com.laboration2.laboration2.repository.CarRepository;
import com.laboration2.laboration2.repository.PersonRepository;

@Service
public class CarServiceImpl implements CarService {
    
    @Autowired 
    CarRepository carRepository;

    @Autowired 
    PersonRepository personRepository;

    @Override
    public Car getCar(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Car saveCar(Car car, Long personId) {
        Person person = personRepository.findById(personId).get();
        car.setPerson(person);
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCars() {
        return (List<Car>)carRepository.findAll();
    }



}
