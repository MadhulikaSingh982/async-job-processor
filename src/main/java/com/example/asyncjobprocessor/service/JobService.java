package com.example.asyncjobprocessor.service;

import com.example.asyncjobprocessor.model.Job;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JobService {

    Map<String, Job> jobs = new ConcurrentHashMap<>();
}
