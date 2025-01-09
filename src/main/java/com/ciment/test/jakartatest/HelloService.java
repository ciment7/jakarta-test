package com.ciment.test.jakartatest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.elastic.apm.api.Traced;

@Stateless
@LocalBean
public class HelloService {


    @Traced
    public String traceHelloMethod() {
        return "Hello, World!";
    }

}
