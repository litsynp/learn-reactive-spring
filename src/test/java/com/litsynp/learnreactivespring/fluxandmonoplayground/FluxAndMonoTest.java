package com.litsynp.learnreactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

    @Test
    void fluxTest() {

        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                /* .concatWith(Flux.error(new RuntimeException("Exception occurred"))) */
                /* .concatWith(Flux.just("After error")) // Once an error is emitted from Flux, it's not going to send any more data. */
                .log();

        stringFlux
                .subscribe(System.out::println,
                        (e) -> System.err.println("Exception is " + e), // onError event
                        () -> System.out.println("Completed") // onComplete event
                );
    }
}
