package com.pai.pms.repository;

import com.pai.pms.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OpinionRepository  extends JpaRepository<Opinion,Integer> {
}
