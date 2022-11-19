package com.mercadolibre.goal.controller;

import com.google.inject.Inject;
import com.mercadolibre.goal.dao.Person;
import com.mercadolibre.goal.router.Request;
import com.mercadolibre.goal.router.Response;
import com.mercadolibre.goal.service.PersonService;

import java.util.Collection;

public class PersonController {
    // POST, PUT, GET, DELETE

    @Inject
    private PersonService personService;

    // GET all people
    public Collection<Person> getAllPeople(final Request request, final Response response) {
        return personService.getAllPeople();
    }

    //POST
    public Person addNewPerson(final Request request, final Response response) {
        Person newPerson = request.bodyAsClass(Person.class);
        return personService.addNewPerson(newPerson);
    }

    // GET
    public Person getPersonByEmail(final Request request, final Response response) throws Exception {
        return personService.getPersonByEmail(request.pathParam("email"));
    }

    // GET all by first name
    public Collection<Person> getPeopleByFirstName(final Request request, final Response response) {
        return personService.getPeopleByFirstName(request.pathParam("firstName"));
    }

    //GET all by city
    public Collection<Person> getPeopleByCity(final Request request, final Response response) {
        return personService.getPeopleByCity(request.pathParam("city"));
    }

    // GET age average
    public double getAgeAverage(final Request request, final Response response) throws Exception{
        return personService.averageAge();
    }
}
