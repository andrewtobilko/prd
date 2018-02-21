package com.tobilko.a1;

import java.util.List;

import static java.lang.String.format;

public final class Dog extends Animal {

    public Dog(String name, List<? extends Animal> friends) {
        super(name, friends);
    }

    @Override
    public String getSound() {
        return "woof-woof";
    }

    @Override
    public String toString() {
        return format("Dog[%s]", getName());
    }

}
