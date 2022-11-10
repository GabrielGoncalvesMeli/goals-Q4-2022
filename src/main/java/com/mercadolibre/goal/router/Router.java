package com.mercadolibre.goal.router;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

import io.javalin.Javalin;

public class Router {
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

                        }
                    );
                }
        );
    }
}
