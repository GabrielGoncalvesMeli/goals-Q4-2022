package com.mercadolibre.goal.service.interfaces;

import java.util.Collection;
import java.util.List;

public interface IPersonService <T> {
    Collection<T> getAllPeople();

    T addNewPerson(T newPerson);

    T getPersonByEmail(String email) throws Exception;

    List<T> getPeopleByFirstName(String firstName);

    List<T> getPeopleByAge(int age);

    long getTotalPeopleWithAge(int age);

    List<T> getPeopleByCity(String city);

    double averageAge() throws Exception;

    boolean allPeopleIsYoungerOrEqualThan(int maxAge);

    boolean anyOneHasTheName(String name);
}
