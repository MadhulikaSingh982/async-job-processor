package com.example.asyncjobprocessor.listener;

import com.example.asyncjobprocessor.event.JobCreatedEvent;
import com.example.asyncjobprocessor.model.Job;
import com.example.asyncjobprocessor.model.JobStatus;
import com.example.asyncjobprocessor.service.JobService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class JobCreatedEventListener {

    private final Map<String, Job> jobs;

    public JobCreatedEventListener(JobService jobService) {
        this.jobs = jobService.getJobsMap();
    }

    @Async
    @EventListener
    public void handle(JobCreatedEvent event) {

        try {
            Thread.sleep(30000);

            Job job = jobs.get(event.getJobId());
            if (job != null) {
                job.setStatus(JobStatus.COMPLETED);
                job.setProcessedAt(LocalDateTime.now());
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
