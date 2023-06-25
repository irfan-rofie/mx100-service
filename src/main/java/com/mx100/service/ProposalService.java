package com.mx100.service;

import java.util.List;

import com.mx100.dto.ProposalDto;
import com.mx100.model.Proposal;

public interface ProposalService {

	public Proposal submitProposal(ProposalDto dto);
	
	public List<Proposal> findProposalByUser();
	
	public List<Proposal> findProposalByJob(Integer jobPostId);
	
	public Proposal findProposalByUserAndJob(Integer jobPostId);
	
}
