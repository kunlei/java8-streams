package com.learn.java.java8demo.basic;

public class AppleGreenColorPredicate implements ApplePredicate {
  @Override
  public boolean test(Apple apple) {
    return apple.getColor().equals("green");
  }
}
