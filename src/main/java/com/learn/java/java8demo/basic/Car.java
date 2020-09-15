package com.learn.java.java8demo.basic;

public class Car {
  private String color;
  private double weight;
  private int year;

  public Car(String color, double weight, int year) {
    this.color = color;
    this.weight = weight;
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Car{" +
        "color='" + color + '\'' +
        ", weight=" + weight +
        ", year=" + year +
        '}';
  }
}
