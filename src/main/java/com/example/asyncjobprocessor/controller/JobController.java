package com.example.asyncjobprocessor.controller;

import com.example.asyncjobprocessor.model.Job;
import com.example.asyncjobprocessor.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
