package com.ciment.test.jakartatest;

import java.io.IOException;

import io.opentelemetry.api.trace.Span;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TraceIdHeaderResponseFilter implements ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String traceId = Span.current().getSpanContext().getTraceId();
        responseContext.getHeaders()
                       .add("X-Trace-Id", traceId);
    }
}