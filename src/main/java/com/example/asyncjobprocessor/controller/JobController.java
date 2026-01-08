package com.example.asyncjobprocessor.controller;

import com.example.asyncjobprocessor.model.Job;
import com.example.asyncjobprocessor.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public Job submitJob() {
        return jobService.createJob();
    }

    @GetMapping("/{jobId}")
    public Job getJobStatus(@PathVariable String jobId) {
        return jobService.getJob(jobId);
    }
}
