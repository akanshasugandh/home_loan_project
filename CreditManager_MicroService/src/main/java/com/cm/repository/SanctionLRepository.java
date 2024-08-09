package com.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.model.SanctionLetter;

@Repository
public interface SanctionLRepository extends JpaRepository<SanctionLetter, Integer>{

}
