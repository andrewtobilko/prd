package com.tobilko.a1;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

/**
 * Розробити програму на будь-якій мові високого рівня, яка демонструє концепції ООП (наслідування, поліморфізм, інкапсуляція) і містить:
 * - успадкування від абстрактного класу;
 * - публічні та приватні властивості і методи;
 * - перевантаження методів базового класу;
 * - властивості:
 * - простих типів даних (наприклад, string, int...);
 * - посилання на інші об’єкти;
 * - масиви/списки простих типів/об’єктів;
 * - код для створення об’єктів усіх можливих класів, заповнення усіх їх властивостей та виклик усіх методів.
 */
public final class Assignment {

    public static void main(final String[] args) {
        final Cat james = new Cat("James", List.of());
        final Cat hannah = new Cat("Hannah", List.of(james));

        final Dog harry = new Dog("Harry", List.of());
        final Dog ann = new Dog("Ann", List.of(james, hannah, harry));

        final List<Animal> animals = List.of(james, hannah, harry, ann);

        animals
                .stream()
                .map(a -> format("%s: %s", a, a.getSound()))
                .forEach(System.out::println);

        animals
                .stream()
                .map(a -> format("%s -> %s", a.getName(), a.getFriends().stream().map(Animal::getName).collect(toList())))
                .forEach(System.out::println);
    }

}
