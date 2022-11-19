package com.mercadolibre.goal.router;

import io.javalin.http.Context;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JavalinResponse implements Response {
    private Context ctx;

    @Override
    public int status(int statusNumber) {
        ctx.status(statusNumber);
        return ctx.status();
    }
}
