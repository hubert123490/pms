package com.pai.pms.logic.service;

import com.pai.pms.model.dto.OpinionWriteModel;
import com.pai.pms.model.entities.Opinion;
import com.pai.pms.model.entities.Payment;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.OpinionRepository;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.payload.request.AddOpinionRequest;
import com.pai.pms.payload.response.AddOpinionResponse;
import com.pai.pms.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class AddOpinionService {
    Logger logger = LoggerFactory.getLogger(AddOpinionService.class);
    private final PaymentRepository repository;
    private final OpinionRepository opinionRepository;

    public AddOpinionService(PaymentRepository repository, OpinionRepository opinionRepository) {
        this.repository = repository;
        this.opinionRepository = opinionRepository;
    }



    @Transactional
    public AddOpinionResponse addOpinion(AddOpinionRequest request) throws IllegalAccessException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        Payment payment = repository.findById(request.getPaymentId()).orElseThrow();
        if(payment.getAgreement().getClient().getUser().getId() != userImpl.getId()){
            throw new IllegalAccessException("Klient nie kupił tej nieruchomości i nie może wystawić opini");
        }
        List<Opinion> opinions = payment.getAgreement().getClient().getOpinions();
        for (Opinion opinion:
             opinions) {
            if(opinion.getApartment() == payment.getAgreement().getApartment()){
                logger.info("Replacing opinion");
                opinion.setText(request.getOpinion());
                opinion.setPublishedDate(LocalDate.now());
                opinionRepository.save(opinion);
                return new AddOpinionResponse(opinion);
            }
        }
        OpinionWriteModel opinionWriteModel = new OpinionWriteModel(request.getOpinion());
        Opinion opinion = opinionWriteModel.toOpinion(payment);

        opinionRepository.save(opinion);
        return new AddOpinionResponse(opinion);
    }
}
