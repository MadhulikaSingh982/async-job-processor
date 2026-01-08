package com.example.asyncjobprocessor.exception;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(String jobId) {
        super("Job Not Found: " + jobId);
    }
}
