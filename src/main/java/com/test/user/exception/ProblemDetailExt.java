package com.test.user.exception;


//import io.micrometer.tracing.Span;
//import io.micrometer.tracing.Tracer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.util.Assert;



@Getter
@Setter
public class ProblemDetailExt extends ProblemDetail {
    private String traceId;
    private String spanId;
    private long timestamp;
    private Object data;

    private String error;
    public ProblemDetailExt() {
//        timestamp = DatetimeUtils.dateNow().getTime();
    }

//    public static ProblemDetailExt forStatusAndDetailAndTracer(HttpStatusCode status, String detail, Tracer tracer) {
//        Assert.notNull(status, "HttpStatusCode is required");
//        ProblemDetailExt problemDetail = new ProblemDetailExt();
//        problemDetail.setStatus(status.value());
//        problemDetail.setDetail(detail);
//        if(tracer != null) {
//            Span span = tracer.currentSpan();
//            if(span != null && span.context() != null) {
//                problemDetail.setSpanId(span.context().spanId());
//                problemDetail.setTraceId(span.context().traceId());
//            }
//
//        }
//        return problemDetail;
//    }
//
//    public static ProblemDetailExt forStatusAndDetailAndTracerAndError(HttpStatusCode status, String detail, Tracer tracer, String error) {
//        Assert.notNull(status, "HttpStatusCode is required");
//        ProblemDetailExt problemDetail = new ProblemDetailExt();
//        problemDetail.setStatus(status.value());
//        problemDetail.setDetail(detail);
//        problemDetail.setError(error);
//        if(tracer != null) {
//            Span span = tracer.currentSpan();
//            if(span != null && span.context() != null) {
//                problemDetail.setSpanId(span.context().spanId());
//                problemDetail.setTraceId(span.context().traceId());
//            }
//        }
//        return problemDetail;
//    }
}
