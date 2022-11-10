package com.mercadolibre.goal.domain;

import com.mercadolibre.goal.dao.Person;

import java.util.HashMap;

public abstract class PeopleDomain {
    private final HashMap<String, Person> people = new HashMap<>();

    public HashMap<String, Person> getAllPeople () {
        return this.people;
    }

    public void addPerson(Person person) {
        this.people.put(person.getEmail(), person);
    }

    public Person getAPersonByEmail(String email) {
        return this.people.get(email);
    }

    public void deleteAPersonByEmail(String email) {
        this.people.remove(email);
    }

    public void deleteAllPeople() {
        this.people.clear();
    }
}
