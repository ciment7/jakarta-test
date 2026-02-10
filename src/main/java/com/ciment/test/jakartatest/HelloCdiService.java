package com.ciment.test.jakartatest;

import co.elastic.apm.api.CaptureSpan;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloCdiService {


    @CaptureSpan
    public String traceHelloMethod() {
        return "Hello, World!";
    }

}
