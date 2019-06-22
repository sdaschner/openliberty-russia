package com.sebastian_daschner.openliberty_russia;

import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @Inject
    Hello hello;

    @GET
    @Counted(monotonic = true)
    public JsonArray hello() {
        return hello.words().stream()
                .map(Json::createValue)
                .collect(JsonCollectors.toJsonArray());
    }

}
