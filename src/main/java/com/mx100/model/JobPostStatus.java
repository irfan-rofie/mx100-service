package com.mx100.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "job_post_status")
@Where(clause = "is_deleted = 0")
public class JobPostStatus extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "job_post_status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobPostStatusId;
	
	@Column(name = "job_post_status_name")
	private String jobPostStatusName;

}
