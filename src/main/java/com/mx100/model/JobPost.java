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

@Entity
@Getter
@Setter
@Table(name = "job_post")
@Where(clause = "is_deleted = 0")
public class JobPost extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "job_post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobPostId;
	
	@Column(name = "job_post_title")
	private String jobPostTitle;

	@Column(name = "job_post_desc")
	private String jobPostDesc;

	@ManyToOne
	@JoinColumn(name = "job_post_status_id", referencedColumnName = "job_post_status_id")
	private JobPostStatus jobPostStatus;
	
}
