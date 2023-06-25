package com.mx100.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx100.model.MasterUserType;

@Repository
public interface MasterUserTypeRepository extends JpaRepository<MasterUserType, Integer> {

}
