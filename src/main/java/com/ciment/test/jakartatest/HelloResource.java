package com.ciment.test.jakartatest;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;


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