package com.patya.jobtracker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.patya.jobtracker.entity.JobApplication;
import com.patya.jobtracker.service.JobApplicationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

   

    @PostMapping
    public JobApplication addJob(@Valid @RequestBody JobApplication job) {
        return service.addJob(job);
    }

    @GetMapping
    public List<JobApplication> getAllJobs() {
        return service.getAllJobs();
    }

    @PutMapping("/{id}")
    public JobApplication updateJob(@PathVariable Long id, @RequestBody JobApplication job) {
        return service.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return "Deleted Successfully";
    }
}