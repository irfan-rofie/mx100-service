package com.mx100.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx100.model.JobPost;
import com.mx100.model.MasterUser;
import com.mx100.model.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Integer> {

	public Proposal findByUserAndJobPost(MasterUser user, JobPost jobPost);
	
	public List<Proposal> findByUser(MasterUser user);
	
	public List<Proposal> findByJobPost(JobPost jobPost);
}
