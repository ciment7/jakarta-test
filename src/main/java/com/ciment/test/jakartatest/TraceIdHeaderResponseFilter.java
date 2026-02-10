package com.ciment.test.jakartatest;

import java.io.IOException;

import com.sun.net.httpserver.Headers;

import co.elastic.apm.api.ElasticApm;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TraceIdHeaderResponseFilter implements ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
//        String traceId = ElasticApm.currentTransaction()
//                .getTraceId();
//        responseContext.getHeaders()
//                       .add("X-Trace-Id", traceId);

        Span span = Span.current();
        SpanContext spanContext = span.getSpanContext();
        if (spanContext.isValid()) {
            responseContext.getHeaders()
                           .add("X-Trace-Id", spanContext.getTraceId());

        }
    }
}