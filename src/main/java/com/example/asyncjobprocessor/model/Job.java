package com.example.asyncjobprocessor.model;

import java.time.LocalDateTime;

public class Job {
    private String jobId;
    private JobStatus status;
    private LocalDateTime processedAt;
}
