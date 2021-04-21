package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OpinionRepository  extends JpaRepository<Opinion,Integer> {
}
