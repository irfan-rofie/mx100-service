package com.mx100.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx100.constant.JobPostStatusConstant;
import com.mx100.dto.JobPostDto;
import com.mx100.exception.ApplicationException;
import com.mx100.model.JobPost;
import com.mx100.model.JobPostStatus;
import com.mx100.repository.JobPostRepository;
import com.mx100.repository.JobPostStatusRepository;

@Service
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	private JobPostRepository jobPostRepository;
	
	@Autowired
	private JobPostStatusRepository jobPostStatusRepository;
	
	@Autowired
	private MasterUserService userService;
	
	@Override
	public JobPost createJobPost(JobPostDto dto) {
		if (!userService.isEmployer()) {
			throw new ApplicationException("You don't have access this feature!");
		}
		JobPostStatus jobPostStatus = jobPostStatusRepository.findById(dto.getJobPostStatusId()).orElseThrow(
				() -> new ApplicationException(String.format("Job post status with id %s not found!", dto.getJobPostStatusId())));
		JobPost jobPost = new JobPost();
		jobPost.setJobPostTitle(dto.getJobPostTitle());
		jobPost.setJobPostDesc(dto.getJobPostDesc());
		jobPost.setJobPostStatus(jobPostStatus);
		return jobPostRepository.save(jobPost);
	}

	@Override
	public List<JobPost> findJobsPublished() {
		JobPostStatus jobPostStatus = jobPostStatusRepository.findById(JobPostStatusConstant.STATUS_ID_PUBLISH).orElseThrow(
				() -> new ApplicationException("Job post status not found!"));
		return jobPostRepository.findByJobPostStatus(jobPostStatus);
	}

}
