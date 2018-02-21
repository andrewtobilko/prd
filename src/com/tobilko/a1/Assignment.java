package com.tobilko.a1;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public final class Assignment {

    public static void main(final String[] args) {
        // create
        final Cat james = new Cat("James", List.of());
        final Cat hannah = new Cat("Hannah", List.of(james));

        final Dog harry = new Dog("Harry", List.of());
        final Dog ann = new Dog("Ann", List.of(james, hannah, harry));

        // collect
        final List<Animal> animals = List.of(james, hannah, harry, ann);

        // get a sound
        animals
                .stream()
                .map(a -> format("%s: %s", a, a.getSound()))
                .forEach(System.out::println);

        // get friends
        animals
                .stream()
                .map(a -> format("%s -> %s", a.getName(), a.getFriends().stream().map(Animal::getName).collect(toList())))
                .forEach(System.out::println);
    }

}
