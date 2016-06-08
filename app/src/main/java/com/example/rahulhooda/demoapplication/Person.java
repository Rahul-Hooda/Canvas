package com.example.rahulhooda.demoapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul.hooda on 6/1/16.
 */

class Person {
    String name;
    String age;
    int photoId;

    Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    private List<Person> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    public List<Person> initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old"));
        persons.add(new Person("Lavery Maiss", "25 years old"));
        persons.add(new Person("Lillie Watts", "35 years old"));
        return persons;
    }
}