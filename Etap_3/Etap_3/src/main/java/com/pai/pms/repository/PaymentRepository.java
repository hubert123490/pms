package com.pai.pms.repository;

import com.pai.pms.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaymentRepository  extends JpaRepository<Payment,Integer> {
}
