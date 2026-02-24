package com.patya.jobtracker.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.patya.jobtracker.entity.JobApplication;
import com.patya.jobtracker.repository.JobApplicationRepository;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repo;

    public JobApplication addJob(JobApplication job) {
        return repo.save(job);
    }

    public List<JobApplication> getAllJobs() {
        return repo.findAll();
    }

    public JobApplication updateJob(Long id, JobApplication job) {
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

    public void deleteJob(Long id) {
        repo.deleteById(id);
    }
}