package com.pai.pms.logic.service;

import com.pai.pms.model.dto.AgreementWriteModel;
import com.pai.pms.model.dto.PaymentWriteModel;
import com.pai.pms.model.entities.*;
import com.pai.pms.model.repository.*;
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
                          ClientRepository clientRepository, ApartmentRepository apartmentRepository,
                          UserRepository userRepository) {
        this.agreementRepository = agreementRepository;
        this.paymentRepository = paymentRepository;
        this.clientRepository = clientRepository;
        this.apartmentRepository = apartmentRepository;
    }


    public Payment makePayment(PaymentWriteModel paymentWriteModel, AgreementWriteModel agreementWriteModel, int apartmentId){
        Agreement agreement = new Agreement();
        Payment payment = paymentWriteModel.toPayment(agreement);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();
        Client client = clientRepository.findByUser_Id(userImpl.getId()).orElseThrow();
        client.setAmountOfRents(client.getAmountOfRents() + 1);

        Apartment apartment = apartmentRepository.findById(apartmentId).orElse(null);
        if(apartment == null)
            throw new NullPointerException("No apartment found");

        /*SET FIELDS OF AGREEMENT*/
        agreementWriteModel.setAgreementFields(agreement);
        agreement.setClient(client);
        agreement.setApartment(apartment);
        agreement.setLandlord(apartment.getLandlord());
        agreement.setPayment(payment);

        agreementRepository.save(agreement);
        paymentRepository.save(payment);
        return payment;
    }
}
