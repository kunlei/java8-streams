package com.learn.java.java8demo.basic;

import java.util.function.Predicate;
import java.util.List;

public class PredicateTest {

  public static class BiggerThanFive<E> implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
      return integer > 5;
    }
  }

  public static void main(String[] args) {
    List<Integer> nums = List.of(2, 3, 4, 6, 9, 1, 10, 12);

    BiggerThanFive<Integer> btf = new BiggerThanFive<>();
    nums.stream().filter(btf).forEach(System.out::println);

    Predicate<Integer> btf2 = n -> n > 5;
    nums.stream().filter(btf2).forEach(System.out::println);
  }
}
