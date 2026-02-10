package com.ciment.test.jakartatest;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloCdiService {


    @WithSpan
    public String traceHelloMethod() {
        return "Hello, World!";
    }

}
