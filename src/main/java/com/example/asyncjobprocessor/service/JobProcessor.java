package com.example.asyncjobprocessor.service;

import com.example.asyncjobprocessor.model.Job;
import com.example.asyncjobprocessor.model.JobStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class JobProcessor {

    @Async
    public void processJob(String jobId, Map<String, Job> jobs) {

        try {
            Thread.sleep(20000);
            Job job = jobs.get(jobId);
            if(job != null) {
                job.setStatus(JobStatus.COMPLETED);
                job.setProcessedAt(LocalDateTime.now());
            }
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
