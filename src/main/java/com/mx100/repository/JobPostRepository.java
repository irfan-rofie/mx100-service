package com.mx100.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx100.model.JobPost;
import com.mx100.model.JobPostStatus;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

	public List<JobPost> findByJobPostStatus(JobPostStatus jobPostStatus);
	
}
