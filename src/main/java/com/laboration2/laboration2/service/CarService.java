package com.laboration2.laboration2.service;

import java.util.List;

import com.laboration2.laboration2.entity.Car;

public interface CarService {
    Car getCar(Long id);
    Car saveCar(Car person, Long personId);
    List<Car> getCars();
}
