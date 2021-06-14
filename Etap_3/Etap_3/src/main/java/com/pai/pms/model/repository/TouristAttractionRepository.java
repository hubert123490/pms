package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.TouristAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface TouristAttractionRepository  extends JpaRepository<TouristAttraction,Integer> {

    Optional<TouristAttraction> findById(int id);
    List<TouristAttraction> findAllByAddress_City(String city);
}
