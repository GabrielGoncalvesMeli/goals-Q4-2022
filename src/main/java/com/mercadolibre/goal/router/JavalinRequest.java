package com.mercadolibre.goal.router;

import io.javalin.http.Context;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JavalinRequest implements Request{
    private Context ctx;

    @Override
    public String queryParam(final String paramName) {
        return ctx.queryParam(paramName);
    }

    @Override
    public String header(final String headerName) {
        return ctx.header(headerName);
    }

    @Override
    public String pathParam(final String paramName) {
        return ctx.pathParam(paramName);
    }

    @Override
    public String body() {
        return ctx.body();
    }

    @Override
    public String method() {
        return ctx.method();
    }

    @Override
    public <T> T attribute(final String key) {
        return ctx.attribute(key);
    }

    @Override
    public void attribute(final String key, final Object value) {
        ctx.attribute(key, value);
    }

    @Override
    public <T> T bodyAsClass(final Class<T> clazz) {
        return ctx.bodyAsClass(clazz);
    }

    @Override
    public String matchedPath() {
        return ctx.matchedPath();
    }

    @Override
    public String path() {
        return ctx.path();
    }

    @Override
    public String queryString() {
        return ctx.queryString();
    }

    @Override
    public String userAgent() {
        return ctx.userAgent();
    }

    @Override
    public HttpServletRequest raw() {
        return ctx.req;
    }

    @Override
    public Map<String, String> headerMap() {
        return ctx.headerMap();
    }

    @Override
    public String url() {
        return ctx.url();
    }
}
