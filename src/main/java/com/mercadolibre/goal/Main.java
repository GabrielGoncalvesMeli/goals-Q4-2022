package com.mercadolibre.goal;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mercadolibre.goal.router.Router;
import io.javalin.Javalin;

public class Main {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        new Main().init();
    }

    Javalin init() {
        Injector injector = Guice.createInjector();
        final Javalin app = initJavalin();
        injector.getInstance(Router.class).init(app);
        return app;
    }

    private static Javalin initJavalin() {
        return Javalin.create(
                (config) -> {
                    config.showJavalinBanner = false;
                }
        ).start(PORT);
    }
}
