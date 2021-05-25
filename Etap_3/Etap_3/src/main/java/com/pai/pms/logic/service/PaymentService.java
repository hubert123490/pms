package com.pai.pms.logic.service;

import com.pai.pms.model.dto.AgreementWriteModel;
import com.pai.pms.model.dto.PaymentWriteModel;
import com.pai.pms.model.entities.*;
import com.pai.pms.model.repository.*;
import com.pai.pms.payload.request.PaymentRequest;
import com.pai.pms.payload.response.PaymentResponse;
import com.pai.pms.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    private final AgreementRepository agreementRepository;
    private final PaymentRepository paymentRepository;
    private final ClientRepository clientRepository;
    private final ApartmentRepository apartmentRepository;
    Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public PaymentService(AgreementRepository agreementRepository, PaymentRepository paymentRepository,
                          ClientRepository clientRepository, ApartmentRepository apartmentRepository) {
        this.agreementRepository = agreementRepository;
        this.paymentRepository = paymentRepository;
        this.clientRepository = clientRepository;
        this.apartmentRepository = apartmentRepository;
    }


    public PaymentResponse makePayment(PaymentRequest paymentRequest){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        Apartment apartment = apartmentRepository.findById(paymentRequest.getApartmentId()).orElse(null);
        if(apartment == null)
            throw new NullPointerException("No apartment found");

        Client client = clientRepository.findByUser_Id(userImpl.getId()).orElseThrow();
        client.setAmountOfRents(client.getAmountOfRents() + 1);

        Agreement agreement = new AgreementWriteModel(paymentRequest).toAgreement(client, apartment);
        Payment payment = new PaymentWriteModel().toPayment(agreement);
        agreement.setPayment(payment);

        agreementRepository.save(agreement);
        paymentRepository.save(payment);

        return new PaymentResponse(payment, agreement, apartment.getId());
    }


}
