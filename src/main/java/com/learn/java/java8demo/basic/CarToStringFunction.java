package com.learn.java.java8demo.basic;

import java.util.function.Function;

public class CarToStringFunction implements Function<Car, String> {
  @Override
  public String apply(Car car) {
    return car.toString();
  }
}
