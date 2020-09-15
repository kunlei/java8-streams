package com.learn.java.java8demo.basic;

import java.util.function.Predicate;

public class CarWeightPredicate implements Predicate<Car> {
  @Override
  public boolean test(Car car) {
    return car.getWeight() > 1000.0;
  }
}
