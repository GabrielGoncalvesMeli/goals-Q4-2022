package com.mercadolibre.goal.router;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.google.inject.Inject;
import com.mercadolibre.goal.controller.PersonController;
import io.javalin.Javalin;

public class Router {

    @Inject
    private PersonController personController;

    public void init(final Javalin engine) {



        engine.get(
                "/ping",
                ctx -> {
                    ctx.result("pong!");
                }
        );

        engine.routes(
                () -> {
                    path("goals",
                        () -> {

                            get("test", ctx -> {
                                ctx.result("tested");
                            });

                            get("people", ctx -> {
                               ctx.json(
                                       personController
                                       .getAllPeople(new JavalinRequest(ctx), new JavalinResponse(ctx))
                               );
                            });

                            post("person", ctx -> {
                                ctx.json(
                                        personController.addNewPerson(new JavalinRequest(ctx), new JavalinResponse(ctx))
                                );
                            });

                            get("person/{email}", ctx -> {
                                ctx.json(
                                        personController.getPersonByEmail(new JavalinRequest(ctx), new JavalinResponse(ctx))
                                );
                            });

                            get("people/firstName/{firstName}", ctx -> {
                                ctx.json(
                                        personController.getPeopleByFirstName(new JavalinRequest(ctx), new JavalinResponse(ctx))
                                );
                            });

                            get("people/city/{city}", ctx -> {
                                ctx.json(
                                        personController.getPeopleByCity(new JavalinRequest(ctx), new JavalinResponse(ctx))
                                );
                            });

                            get("people/average/age", ctx -> {
                                ctx.json(
                                        personController.getAgeAverage(new JavalinRequest(ctx), new JavalinResponse(ctx))
                                );
                            });
                        }
                    );
                }
        );

        engine.exception(Exception.class, (e, ctx) -> {
            ctx.status(400);
            ctx.json(e.getMessage());
        });
    }
}
