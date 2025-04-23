package com.ciment.test.jakartatest;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class HelloService {


    @WithSpan
    public String traceHelloMethod() {
        return "Hello, World! " + Span.current().getSpanContext().getTraceId();
    }

}
