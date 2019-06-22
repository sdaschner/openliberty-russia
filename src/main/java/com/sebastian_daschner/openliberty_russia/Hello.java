package com.sebastian_daschner.openliberty_russia;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class Hello {

    @CircuitBreaker(requestVolumeThreshold = 10, failureRatio = 0.3, delay = 2000)
    @Fallback(fallbackMethod = "fallback")
    public List<String> words() {

        if (new Random().nextDouble() < 0.3)
            throw new IllegalStateException("!");

        return List.of(
                "Привет",
                "Питер",
                "Кофе");
    }

    public List<String> fallback() {
       return List.of("Извините!");
    }

}
