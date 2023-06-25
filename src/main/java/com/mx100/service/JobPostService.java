package com.mx100.service;

import java.util.List;

import com.mx100.dto.JobPostDto;
import com.mx100.model.JobPost;

public interface JobPostService {

	public JobPost createJobPost(JobPostDto dto);
	
	public List<JobPost> findJobsPublished();
}
