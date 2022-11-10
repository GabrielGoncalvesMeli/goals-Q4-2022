package com.mercadolibre.goal.router;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface Request {
    String queryParam(String paramName);

    String header(String paramName);

    String pathParam(String paramName);

    String body();

    String method();

    <T> T attribute(String key);

    void attribute(String key, Object value);

    <T> T bodyAsClass(Class<T> clazz);

    String matchedPath();

    String path();

    String queryString();

    String userAgent();

    HttpServletRequest raw();

    Map<String, String> headerMap();

    String url();
}
