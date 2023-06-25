package com.mx100.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx100.dto.ProposalDto;
import com.mx100.exception.ApplicationException;
import com.mx100.model.JobPost;
import com.mx100.model.MasterUser;
import com.mx100.model.Proposal;
import com.mx100.repository.JobPostRepository;
import com.mx100.repository.MasterUserRepository;
import com.mx100.repository.ProposalRepository;
import com.mx100.util.Mx100Util;

@Service
public class ProposalServiceImpl implements ProposalService {

	@Autowired
	private MasterUserService userService;
	
	@Autowired
	private ProposalRepository proposalRepository;
	
	@Autowired
	private MasterUserRepository userRepository;
	
	@Autowired
	private JobPostRepository jobPostRepository;
	
	@Override
	public Proposal submitProposal(ProposalDto dto) {
		if (!userService.isFreelancer()) {
			throw new ApplicationException("You don't have access this feature!");
		}
		MasterUser user = getUser();
		JobPost jobPost = getJobPost(dto.getJobPostId());
		Proposal proposal = proposalRepository.findByUserAndJobPost(user, jobPost);
		if (proposal != null) {
			throw new ApplicationException("You have submitted proposal for this Job!");
		}
		proposal = new Proposal();
		proposal.setJobPost(jobPost);
		proposal.setUser(user);
		proposal.setMessage(dto.getMessage());
		return proposalRepository.save(proposal);
	}

	@Override
	public List<Proposal> findProposalByUser() {
		if (!userService.isFreelancer()) {
			throw new ApplicationException("You don't have access this feature!");
		}
		MasterUser user = getUser();
		return proposalRepository.findByUser(user);
	}

	@Override
	public List<Proposal> findProposalByJob(Integer jobPostId) {
		if (!userService.isEmployer()) {
			throw new ApplicationException("You don't have access this feature!");
		}
		JobPost jobPost = getJobPost(jobPostId);
		return proposalRepository.findByJobPost(jobPost);
	}

	@Override
	public Proposal findProposalByUserAndJob(Integer jobPostId) {
		if (!userService.isFreelancer()) {
			throw new ApplicationException("You don't have access this feature!");
		}
		MasterUser user = getUser();
		JobPost jobPost = getJobPost(jobPostId);
		return proposalRepository.findByUserAndJobPost(user, jobPost);
	}

	private JobPost getJobPost(Integer jobPostId) {
		JobPost jobPost = jobPostRepository.findById(jobPostId).orElseThrow(
				() -> new ApplicationException(String.format("Job post with id %s not found!", jobPostId)));
		return jobPost;
	}
	
	private MasterUser getUser() {
		String username = Mx100Util.getUsername();
		MasterUser user = userRepository.findOneByUsername(username);
		if (user == null) {
			throw new ApplicationException(String.format("User with username %s not found!", username));
		}
		return user;
	}
	
}
