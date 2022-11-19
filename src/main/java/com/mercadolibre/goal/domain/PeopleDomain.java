package com.mercadolibre.goal.domain;

import com.mercadolibre.goal.dao.Person;

import java.util.HashMap;
import java.util.Optional;

public abstract class PeopleDomain {
    private static final HashMap<String, Person> people = new HashMap<>();

    public static HashMap<String, Person> getAllPeople () {
        return people;
    }

    public static void addPerson(Person person) {
        people.put(person.getEmail(), person);
    }

    public static Optional<Person> getAPersonByEmail(String email) {
        return Optional.of(people.get(email));
    }

    public static void deleteAPersonByEmail(String email) {
        people.remove(email);
    }

    public static void deleteAllPeople() {
        people.clear();
    }
}
