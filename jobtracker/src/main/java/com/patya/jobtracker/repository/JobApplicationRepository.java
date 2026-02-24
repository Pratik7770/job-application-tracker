package com.patya.jobtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.patya.jobtracker.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}