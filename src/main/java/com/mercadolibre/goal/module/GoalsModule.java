package com.mercadolibre.goal.module;

import com.google.inject.AbstractModule;
import com.mercadolibre.goal.controller.PersonController;
import com.mercadolibre.goal.service.PersonService;

public class GoalsModule extends AbstractModule {

    @Override
    protected void configure() {
        // Controller
        bind(PersonController.class).asEagerSingleton();

        // Service
        bind(PersonService.class).asEagerSingleton();

    }
}
