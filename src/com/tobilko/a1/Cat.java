package com.tobilko.a1;

import java.util.List;

import static java.lang.String.format;

public final class Cat extends Animal {

    public Cat(String name, List<? extends Animal> friends) {
        super(name, friends);
    }

    @Override
    public String getSound() {
        return "mew-mew";
    }

    @Override
    public String toString() {
        return format("Cat[%s]", getName());
    }

}
