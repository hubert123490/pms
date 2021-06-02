package com.pai.pms.logic.service;

import com.pai.pms.model.dto.BoughtApartmentDetailReadModel;
import com.pai.pms.model.entities.Payment;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BoughtApartmentDetailService {
    private final PaymentRepository repository;
    Logger logger = LoggerFactory.getLogger(BoughtApartmentDetailService.class);

    public BoughtApartmentDetailService(PaymentRepository repository) {
        this.repository = repository;
    }

    public BoughtApartmentDetailReadModel readBoughtApartmentDetail(int paymentId) throws IllegalAccessException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl) authentication.getPrincipal();

        Payment payment = repository.findById(paymentId).orElse(null);
        if (payment != null && payment.getAgreement().getClient().getUser().getId() == userImpl.getId()) {
            return new BoughtApartmentDetailReadModel(payment);
        } else {
            throw new IllegalAccessException("Payment id does not belong to this client");
        }
    }
}
