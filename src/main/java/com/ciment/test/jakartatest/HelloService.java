package com.ciment.test.jakartatest;

import co.elastic.apm.api.Traced;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class HelloService {


    @Traced
    public String traceHelloMethod() {
        return "Hello, World!";
    }

}
