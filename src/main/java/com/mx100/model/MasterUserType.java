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
@Table(name = "master_user_type")
@Where(clause = "is_deleted = 0")
public class MasterUserType extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userTypeId;
	
	@Column(name = "user_type_name")
	private String userTypeName;
	
}