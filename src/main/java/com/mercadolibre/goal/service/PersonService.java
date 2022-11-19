package com.mercadolibre.goal.service;

import com.mercadolibre.goal.dao.Person;
import com.mercadolibre.goal.domain.PeopleDomain;
import com.mercadolibre.goal.service.interfaces.IPersonService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonService implements IPersonService<Person> {

    public Collection<Person> getAllPeople() {
        return PeopleDomain.getAllPeople().values();
    }

    public Person addNewPerson(Person newPerson) {
        PeopleDomain.addPerson(newPerson);
        return newPerson;
    }

    public Person getPersonByEmail(String email) throws Exception {
        try {
            Optional<Person> personByEmail = PeopleDomain.getAPersonByEmail(email);
            if (personByEmail.isPresent()) {
                return personByEmail.get();
            }
            throw new Exception("Person not founded");
        } catch (Exception e) {
            throw new Exception("Person not founded");
        }

    }

    public List<Person> getPeopleByFirstName(String firstName) {
        Collection<Person> people = PeopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
    }

    public List<Person> getPeopleByAge(int age) {
        Collection<Person> people = PeopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getAge() == age).collect(Collectors.toList());
    }

    public long getTotalPeopleWithAge(int age) {
        Collection<Person> people = PeopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getAge() == age).count();
    }

    public List<Person> getPeopleByCity(String city) {
        Collection<Person> people = PeopleDomain.getAllPeople().values();
        return people.stream().filter(p -> p.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

    public double averageAge() throws Exception {
        Collection<Person> people = PeopleDomain.getAllPeople().values();
        if(people.isEmpty()) throw new Exception("No person registered yet");
        double sumAges = people.stream().mapToDouble(Person::getAge).sum();
        return sumAges / people.size();
    }

    public boolean allPeopleIsYoungerOrEqualThan(int maxAge) {
        Collection<Person> people = PeopleDomain.getAllPeople().values();
        return people.stream().allMatch(p -> p.getAge() <= maxAge);
    }

    public boolean anyOneHasTheName(String name) {
        Collection<Person> people = PeopleDomain.getAllPeople().values();
        return people.stream().anyMatch(p -> p.getFirstName().equalsIgnoreCase(name));
    }
}
