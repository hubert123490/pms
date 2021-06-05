package com.pai.pms.logic.service;

import com.pai.pms.model.dto.PaymentDetailReadModel;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.security.services.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentDetailService {
    private final PaymentRepository paymentRepository;

    public PaymentDetailService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDetailReadModel> readAllClientPayments(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        return paymentRepository.findAllByAgreement_Client_User_Id(userImpl.getId()).stream().map(PaymentDetailReadModel::new).collect(Collectors.toList());
    }
}
