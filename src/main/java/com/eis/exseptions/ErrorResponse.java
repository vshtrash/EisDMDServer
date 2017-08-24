package com.eis.exseptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse  {
    private HttpStatus status;
    private String message;
    private StackTraceElement[] stackTrace;

    public ErrorResponse() {
    }

    public ErrorResponse(HttpStatus status, String message, StackTraceElement[] stackTrace) {
        this.status = status;
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }
}
