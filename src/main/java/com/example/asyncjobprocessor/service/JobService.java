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
    private final JobProcessor jobProcessor;

    public JobService(JobProcessor jobProcessor) {
        this.jobProcessor = jobProcessor;
    }

    public Job createJob() {
        String jobId = UUID.randomUUID().toString();

        Job job = new Job();
        job.setJobId(jobId);
        job.setStatus(JobStatus.PROCESSING);

        jobs.put(jobId, job);

        jobProcessor.processJob(jobId, jobs);

        return job;
    }

    public Job getJob(String jobId) {
        return jobs.get(jobId);
    }
}
