package com.pai.pms.model.repository;

import com.pai.pms.model.entities.TouristAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@RepositoryRestResource
public interface TouristAttractionRepository  extends JpaRepository<TouristAttraction,Integer> {

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(TouristAttraction touristAttraction);

}
