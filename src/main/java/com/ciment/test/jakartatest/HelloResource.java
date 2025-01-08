package com.ciment.test.jakartatest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;

@Path("/hello-world")
@Stateless
@LocalBean
public class HelloResource {

    @Resource
    private ManagedExecutorService mes;

    @Inject
    private HelloService helloService;

    @GET
    @Produces("text/plain")
    public String hello() {
        return helloService.traceHelloMethod();
    }




    @GET
    @Path("/async")
    @Produces("text/plain")
    public void helloAsync(@Suspended AsyncResponse response) {

        CompletableFuture.supplyAsync(()-> "Hello, World! - ASYNC", mes)
                .handle((asyncResponse, throwable) -> {
            if (throwable != null) {
                response.resume(throwable);
                return null;
            }
            response.resume(asyncResponse);
            return null;
        });


    }
}