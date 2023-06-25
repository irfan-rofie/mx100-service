package com.mx100.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx100.model.MasterUser;

@Repository
public interface MasterUserRepository extends JpaRepository<MasterUser, Integer> {
	
	public MasterUser findOneByUsername(String username);

}
