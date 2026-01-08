package com.example.asyncjobprocessor.event;

public class JobCreatedEvent {

    private final String jobId;

    public JobCreatedEvent(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }
}
