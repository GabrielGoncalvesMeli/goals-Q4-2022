package com.mercadolibre.goal.service;

import com.google.inject.Inject;
import com.mercadolibre.goal.dao.Person;
import com.mercadolibre.goal.domain.PeopleDomain;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonService {

    @Inject
    private PeopleDomain peopleDomain;


    public Collection<Person> getAllPeople() {
        return peopleDomain.getAllPeople().values();
    }

    public Person getPersonByEmail(String email) {
        return peopleDomain.getAPersonByEmail(email);
    }

    public List<Person> getPeopleByFirstName(String firstName) {
        Collection<Person> people = peopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
    }

    public List<Person> getPeopleByAge(int age) {
        Collection<Person> people = peopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getAge() == age).collect(Collectors.toList());
    }

    public long getTotalPeopleWithAge(int age) {
        Collection<Person> people = peopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getAge() == age).count();
    }

    public List<Person> getPeopleByCity(String city) {
        Collection<Person> people = peopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

    public int sumAllAges(Person.UserType type) {
        Collection<Person> people = peopleDomain.getAllPeople().values();
        return people.stream().mapToInt(Person::getAge).sum();
    }

    public boolean allPeopleIsYoungerOrEqualThan(int maxAge) {
        Collection<Person> people = peopleDomain.getAllPeople().values();
        return people.stream().allMatch(p -> p.getAge() <= maxAge);
    }

    public boolean anyOneHasTheName(String name) {
        Collection<Person> people = peopleDomain.getAllPeople().values();
        return people.stream().anyMatch(p -> p.getFirstName().equalsIgnoreCase(name));
    }
}
