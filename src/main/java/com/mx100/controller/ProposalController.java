package com.mx100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx100.dto.ProposalDto;
import com.mx100.model.Proposal;
import com.mx100.response.Response;
import com.mx100.service.ProposalService;

@RestController
@RequestMapping("/api/proposal")
public class ProposalController {

	@Autowired
	private ProposalService proposalService;
	
	@PostMapping("/submit")
	public ResponseEntity<?> submitProposal(@RequestBody ProposalDto dto) {
		Response<Proposal> response = new Response<>();
		try {
			Proposal proposal = proposalService.submitProposal(dto);
			response.setStatus(Response.SUCCESS);
			response.setMessage("Success submit propsal!");
			response.setData(proposal);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Response.ERROR);
			response.setMessage(String.format("Failed to submit proposal!, message : %s", e.getMessage()));
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find-by-job/{jobPostId}")
	public ResponseEntity<?> findProposalByJob(@PathVariable Integer jobPostId) {
		Response<List<Proposal>> response = new Response<>();
		try {
			List<Proposal> proposals = proposalService.findProposalByJob(jobPostId);
			response.setStatus(Response.SUCCESS);
			response.setMessage(proposals.isEmpty() ? "Propsals not found!" : "Success find propsals!");
			response.setData(proposals);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Response.ERROR);
			response.setMessage(String.format("Failed to find proposals!, message : %s", e.getMessage()));
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find-by-user")
	public ResponseEntity<?> findProposalByUser() {
		Response<List<Proposal>> response = new Response<>();
		try {
			List<Proposal> proposals = proposalService.findProposalByUser();
			response.setStatus(Response.SUCCESS);
			response.setMessage(proposals.isEmpty() ? "Propsals not found!" : "Success find propsals!");
			response.setData(proposals);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Response.ERROR);
			response.setMessage(String.format("Failed to find proposals!, message : %s", e.getMessage()));
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/find-by-user-and-job/{jobPostId}")
	public ResponseEntity<?> findProposalByUserAndJob(@PathVariable Integer jobPostId) {
		Response<Proposal> response = new Response<>();
		try {
			Proposal proposal = proposalService.findProposalByUserAndJob(jobPostId);
			response.setStatus(Response.SUCCESS);
			response.setMessage(proposal == null ? "Propsal not found!" : "Success find propsal!");
			response.setData(proposal);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Response.ERROR);
			response.setMessage(String.format("Failed to find proposal!, message : %s", e.getMessage()));
		}
		return ResponseEntity.ok(response);
	}

}
