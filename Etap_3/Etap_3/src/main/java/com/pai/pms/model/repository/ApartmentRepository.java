package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface ApartmentRepository  extends JpaRepository<Apartment,Integer> {

    List<Apartment> findAllByDateFromLessThanEqualAndDateToGreaterThanEqual(LocalDate from, LocalDate to);

    List<Apartment> findAllByName(String name);

    List<Apartment> findAllByAddress_City(String city);

    List<Apartment> findAllByDateFromLessThanAndDateToGreaterThanAndAddress_City(LocalDate from, LocalDate to, String city);

    Optional<Apartment> findById(int id);

    List<Apartment> findAllByDateFromLessThan(LocalDate from);

    List<Apartment> findAllByLandlord_User_Id(Integer id);

}
