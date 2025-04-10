package com.bhagirathi.training.aws.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhagirathi.training.aws.dbmodel.EntityPlace;

@Repository
public interface RepoPlaces extends JpaRepository<EntityPlace, Long>{

}
