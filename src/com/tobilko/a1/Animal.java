package com.tobilko.a1;

import java.util.List;

import static java.lang.String.format;

public abstract class Animal implements Nameable {

    private final String name;
    private final List<? extends Animal> friends;

    public Animal(final String name, final List<? extends Animal> friends) {
        this.name = name;
        this.friends = friends;
    }

    public abstract String getSound();

    @Override
    public String getName() {
        return name;
    }

    public List<? extends Animal> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return format("Animal[name=%s]", name);
    }

}
