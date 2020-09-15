package com.learn.java.java8demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import javax.swing.text.html.Option;

public class RabbitTest {
  public static void main(String[] args) {
    List<Rabbit> rabbits = Arrays.asList(
        new Rabbit("Jack", "green", 3.0, 2),
        new Rabbit("Tom", "yellow", 2.8, 3),
        new Rabbit("AAA", "brown", 3.4, 1),
        new Rabbit("BBB", "grey", 5.0, 4),
        new Rabbit("abc", "red", 1.2, 1)
    );

    // filtering
    List<Rabbit> lightRabbits = rabbits.stream()
        .filter(r -> r.getWeight() < 3)
        .collect(Collectors.toList());
    lightRabbits.forEach(System.out::println);

    System.out.println();
    // filtering unique
    List<Rabbit> lightUniqueRabbits = rabbits.stream()
        .filter(r -> r.getWeight() < 4)
        .distinct()
        .collect(Collectors.toList());
    lightUniqueRabbits.forEach(System.out::println);

    System.out.println();

    // truncating a stream
    List<Rabbit> rabbitGroup1 = rabbits.stream()
        .filter(r -> r.getHeight() > 1)
        .limit(2)
        .collect(Collectors.toList());
    rabbitGroup1.forEach(System.out::println);

    System.out.println();

    // skipping a stream
    List<Rabbit> rabbitGroup2 = rabbits.stream()
        .filter(r -> r.getHeight() > 1)
        .skip(2)
        .collect(Collectors.toList());
    rabbitGroup2.forEach(System.out::println);

    System.out.println();

    // applying a function to each element of a stream
    List<String> rabbitNames = rabbits.stream()
        .map(r -> r.getName())
        .collect(Collectors.toList());
    rabbitNames.forEach(System.out::println);

    System.out.println();

    // flattening streams
    List<String> uniqueChars = rabbits.stream()
        .map(r -> r.getName().split(""))
        .flatMap(w -> Arrays.stream(w))
        .distinct()
        .collect(Collectors.toList());
    uniqueChars.forEach(System.out::println);

    System.out.println();

    // checking to see if a predicate matches at least one element
    boolean atLeastOneMatch = rabbits.stream().anyMatch(r -> r.getColor().equals("green"));
    System.out.println(atLeastOneMatch);

    System.out.println();

    // checking to see if a predicate matches all elements
    boolean allMatches = rabbits.stream().allMatch(r -> r.getWeight() > 1);
    System.out.println(allMatches);

    // checking to see if a predicate has no match
    boolean noMatch = rabbits.stream().noneMatch(r -> r.getHeight() > 3);
    System.out.println(noMatch);

    // finding an element
    Optional<Rabbit> rabbit1 = rabbits.stream()
        .filter(r -> r.getColor().equals("green"))
        .findAny();
    rabbit1.ifPresent(r -> System.out.println(r.getName()));

    System.out.println();

    // finding the first element
    Optional<Rabbit> rabbit2 = rabbits.stream()
        .filter(r -> r.getWeight() > 1)
        .findFirst();
    rabbit2.ifPresent(r -> System.out.println(r.getName()));

    System.out.println();

    // Reducing operations
    // summing the elements
    double weightSum = rabbits.stream()
        .map(r -> r.getWeight())
        .reduce(0.0, (a, b) -> a + b);
    System.out.println(weightSum);

    System.out.println();

    // weight product
    double weightProd = rabbits.stream()
        .map(r -> r.getWeight())
        .reduce(0.0, (a, b) -> a * b);
    System.out.println(weightProd);

    System.out.println();

    // finding the maximum
    double maxWeight = rabbits.stream()
        .map(r -> r.getWeight())
        .reduce(0.0, (a, b) -> a > b ? a : b);
    System.out.println(maxWeight);

    System.out.println();

  }

}
