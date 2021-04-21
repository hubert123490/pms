package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository  extends JpaRepository<Address,Integer> {
}
