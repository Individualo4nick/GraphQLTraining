package com.example.api7.resolver;

import com.example.api7.entity.Car;
import com.example.api7.repo.CarRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final CarRepository carRepository;

    public CarResolver(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCar(Long id) {
        return carRepository.findById(id);
    }

    public Car addCar(String title,
                      String brand,
                      double price,
                      int age) {
        Car car = Car.builder()
                .title(title)
                .brand(brand)
                .price(price)
                .age(age)
                .build();
        return carRepository.save(car);
    }
    public Car updateCar(Long id, String title,
                      String brand,
                      double price,
                      int age) {
        Car car = Car.builder()
                .id(id)
                .title(title)
                .brand(brand)
                .price(price)
                .age(age)
                .build();
        return carRepository.save(car);
    }
    public Optional<Car> deleteCar(Long id) {
        carRepository.deleteById(id);
        return carRepository.findById(id);
    }
}
