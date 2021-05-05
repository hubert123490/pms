package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ApartmentRepository  extends JpaRepository<Apartment,Integer> {

    List<Apartment> findAllByDateFromLessThanAndDateToGreaterThan(LocalDate from, LocalDate to);

    List<Apartment> findAllByName(String name);
}
