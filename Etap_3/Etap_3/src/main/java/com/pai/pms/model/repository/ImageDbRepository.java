package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDbRepository extends JpaRepository<Image, Long> {
    @Override
    Optional<Image> findById(Long aLong);
}
