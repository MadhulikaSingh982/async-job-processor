package com.example.asyncjobprocessor.service;

import com.example.asyncjobprocessor.model.Job;
import com.example.asyncjobprocessor.model.JobStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class JobService {

    Map<String, Job> jobs = new ConcurrentHashMap<>();

    public Job createJob() {
        String jobId = UUID.randomUUID().toString();

        Job job = new Job();
        job.setJobId(jobId);
        job.setStatus(JobStatus.PROCESSING);

        jobs.put(jobId, job);

        processJobAsync(jobId);

        return job;
    }

    @Async
    public void processJobAsync(String jobId) {
        try {
            // Simulate long-running work
            Thread.sleep(3000);

            Job job = jobs.get(jobId);
            if(job != null) {
                job.setStatus(JobStatus.COMPLETED);
                job.setProcessedAt(LocalDateTime.now());
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
