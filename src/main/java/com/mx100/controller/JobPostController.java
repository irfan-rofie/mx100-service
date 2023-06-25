package com.mx100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx100.Response.Response;
import com.mx100.dto.JobPostDto;
import com.mx100.model.JobPost;
import com.mx100.service.JobPostService;

@RestController
@RequestMapping("/api/job/post")
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createJobPost(@RequestBody JobPostDto dto) {
		Response<JobPost> response = new Response<>();
		try {
			JobPost jobPost = jobPostService.createJobPost(dto);
			response.setStatus(Response.SUCCESS);
			response.setMessage("Success create job post!");
			response.setData(jobPost);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Response.ERROR);
			response.setMessage(String.format("Failed create job post!, message : %s", e.getMessage()));
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/published")
	public ResponseEntity<?> findJobsPublished() {
		Response<List<JobPost>> response = new Response<>();
		try {
			List<JobPost> jobs = jobPostService.findJobsPublished();
			response.setStatus(Response.SUCCESS);
			response.setMessage("Success find jobs published!");
			response.setData(jobs);			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Response.ERROR);
			response.setMessage(String.format("Failed find jobs published!, message : %s", e.getMessage()));
		}
		return ResponseEntity.ok(response);
	}
	
}
