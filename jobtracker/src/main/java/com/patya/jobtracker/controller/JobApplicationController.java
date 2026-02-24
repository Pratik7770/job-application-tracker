package com.patya.jobtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.patya.jobtracker.entity.JobApplication;
import com.patya.jobtracker.repository.JobApplicationRepository;

@RestController
@RequestMapping("/jobs")
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository repo;

    // Add Job Application
    @PostMapping
    public JobApplication addJob(@RequestBody JobApplication job) {
        return repo.save(job);
    }

    // Get All Jobs
    @GetMapping
    public List<JobApplication> getAllJobs() {
        return repo.findAll();
    }

    // Delete Job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    // Update Status
    @PutMapping("/{id}")
    public JobApplication updateJob(@PathVariable Long id, @RequestBody JobApplication job) {
        JobApplication existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setCompanyName(job.getCompanyName());
            existing.setRole(job.getRole());
            existing.setStatus(job.getStatus());
            existing.setAppliedDate(job.getAppliedDate());
            return repo.save(existing);
        }
        return null;
    }
}