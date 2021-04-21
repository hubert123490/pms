package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Integer> {
}
