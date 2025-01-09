package com.ciment.test.jakartatest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import co.elastic.apm.api.ElasticApm;

@Provider
public class TraceIdHeaderResponseFilter implements ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String traceId = ElasticApm.currentTransaction()
                .getTraceId();
        responseContext.getHeaders()
                       .add("X-Trace-Id", traceId);
    }
}