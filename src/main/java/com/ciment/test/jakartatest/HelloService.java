package com.ciment.test.jakartatest;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class HelloService {


    //    @WithSpan
//    Exception while invoking class org.glassfish.ejb.startup.EjbApplication start method java.lang
//    .IllegalStateException: org.glassfish.deployment.common.DeploymentException: A class fish.payara.microprofile
//    .telemetry.tracing.WithSpanMethodInterceptorBean doesn't have any appropriate constructor
    public String traceHelloMethod() {
        return "Hello, World!";
    }

}
