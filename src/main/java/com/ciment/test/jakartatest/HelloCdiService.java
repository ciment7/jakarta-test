package com.ciment.test.jakartatest;

import co.elastic.apm.api.Traced;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloCdiService {


    @Traced
    public String traceHelloMethod() {
        return "Hello, World!";
    }

}
