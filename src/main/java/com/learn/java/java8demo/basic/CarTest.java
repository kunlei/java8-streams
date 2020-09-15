package com.learn.java.java8demo.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarTest {
  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();
    cars.add(new Car("green", 1000.0, 2018));
    cars.add(new Car("blue", 2000.0, 2020));
    cars.add(new Car("maroon", 3000.0, 2019));
    cars.add(new Car("yellow", 2500.0, 2020));
    cars.add(new Car("purple", 999.0, 2021));

    Predicate<Car> weightPredicate = new CarWeightPredicate();
    cars.stream().filter(weightPredicate)
        .collect(Collectors.toList())
        .forEach(System.out::println);
    System.out.println();

    Predicate<Car> yearPredicate = car -> car.getYear() > 2019;
    cars.stream().filter(yearPredicate)
        .collect(Collectors.toList())
        .forEach(System.out::println);
    System.out.println();

    Predicate<Car> andPredicate = weightPredicate.and(yearPredicate);
    cars.stream().filter(andPredicate)
        .collect(Collectors.toList())
        .forEach(System.out::println);
    System.out.println();

    Predicate<Car> orPredicate = weightPredicate.or(yearPredicate);
    cars.stream().filter(orPredicate)
        .collect(Collectors.toList())
        .forEach(System.out::println);
    System.out.println();

    Predicate<Car> negatePredicate = weightPredicate.negate();
    cars.stream().filter(negatePredicate)
        .collect(Collectors.toList())
        .forEach(System.out::println);
    System.out.println();

    // test Function<T, R> interface
    Function<Car, String> carToStringFunction = new CarToStringFunction();
    cars.stream().map(carToStringFunction).collect(Collectors.toList()).forEach(System.out::println);
    System.out.println();

    Function<Car, String> carStringFunction2 = c -> c.toString();
    cars.stream().map(carStringFunction2).collect(Collectors.toList()).forEach(System.out::println);
    System.out.println();

    Function<String, String> carCapFunc = s -> s.toUpperCase();
    cars.stream().map(carStringFunction2.andThen(carCapFunc)).collect(Collectors.toList()).forEach(System.out::println);
    System.out.println();

    Function<Car, Car> carCarFunction = c -> {
      c.setColor(c.getColor().toUpperCase());
      return c;
    };
    cars.stream().map(carStringFunction2.compose(carCarFunction)).collect(Collectors.toList()).forEach(System.out::println);
    System.out.println();

  }
}
