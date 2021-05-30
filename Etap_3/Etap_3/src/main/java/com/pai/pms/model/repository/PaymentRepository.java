package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Integer> {
    @Override
    <S extends Payment> S save(S s);

    List<Payment> findAllByAgreement_Client_User_Id(Integer id);
}
