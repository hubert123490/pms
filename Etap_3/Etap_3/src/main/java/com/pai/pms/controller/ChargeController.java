package com.pai.pms.controller;

import com.pai.pms.logic.service.PaymentService;
import com.pai.pms.logic.service.StripeService;
import com.pai.pms.model.entities.Payment;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.payload.request.ChargeRequest;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@Log
@Controller
public class ChargeController {
    Logger logger = LoggerFactory.getLogger(ChargeController.class);

    PaymentRepository paymentRepository;
    StripeService paymentsService;

    public ChargeController(PaymentRepository paymentRepository, StripeService paymentsService) {
        this.paymentRepository = paymentRepository;
        this.paymentsService = paymentsService;
    }

    @PostMapping("/charge")
    @Transactional
    public String charge(ChargeRequest chargeRequest, Model model) throws StripeException {
        Payment payment = paymentRepository.findById(chargeRequest.getPaymentId()).orElseThrow();
        if(payment.isPaymentDone())
            throw new IllegalStateException("Apartament został już wcześniej opłacony");
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.PLN);
        Charge charge = paymentsService.charge(chargeRequest);
        payment.setPaymentDone(true);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String handlePaymentException(Model model, IllegalStateException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
