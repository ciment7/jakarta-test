package com.ciment.test.jakartatest;

import java.util.concurrent.CompletableFuture;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;

@Path("/cdi/hello-world")
@ApplicationScoped
public class HelloCdiResource {

    @Resource
    private ManagedExecutorService mes;

    @Inject
    private HelloCdiService helloService;

    @GET
    @Produces("text/plain")
    public String hello() {
        return helloService.traceHelloMethod();
    }




    @GET
    @Path("/async")
    @Produces("text/plain")
    public void helloAsync(@Suspended AsyncResponse response) {

        CompletableFuture.supplyAsync(()->{
                            helloService.traceHelloMethod();
                             return "Hello, World! - ASYNC";
                         } , mes)
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