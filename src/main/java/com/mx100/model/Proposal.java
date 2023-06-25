package com.mx100.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proposal")
@Where(clause = "is_deleted = 0")
public class Proposal extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "proposal_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer proposalId;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private MasterUser user;

	@ManyToOne
	@JoinColumn(name = "job_post_id", referencedColumnName = "job_post_id")
	private JobPost jobPost;

	@Column(name = "message")
	private String message;
	
}
