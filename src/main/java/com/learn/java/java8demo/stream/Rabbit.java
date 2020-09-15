package com.learn.java.java8demo.stream;

import java.util.Objects;

public class Rabbit {
  private final String name;
  private final String color;
  private final double weight;
  private final int height;

  public Rabbit(String name, String color, double weight, int height) {
    this.name = name;
    this.color = color;
    this.weight = weight;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public double getWeight() {
    return weight;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rabbit rabbit = (Rabbit) o;
    return Double.compare(rabbit.weight, weight) == 0 &&
        height == rabbit.height &&
        Objects.equals(name, rabbit.name) &&
        Objects.equals(color, rabbit.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, color, weight, height);
  }
}
