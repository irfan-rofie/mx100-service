package com.mx100.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mx100.util.Mx100Util;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@Column(name = "is_deleted")
	private short isDeleted;

	@PrePersist
	public void prePersist() {
		try {
			if (Mx100Util.isAuthenticated()) {
				this.createdBy = Mx100Util.getUsername();
			}
		} catch(Exception e){
			
		}	
		this.isDeleted = 0;
		this.createdDate = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		try {
			if (Mx100Util.isAuthenticated()) {
				this.modifiedBy = Mx100Util.getUsername();
			}
		} catch(Exception e){
			
		}		
		this.modifiedDate = new Date();
	}
	
}
