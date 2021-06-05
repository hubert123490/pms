package com.pai.pms.controller;

import com.pai.pms.model.entities.Payment;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.payload.request.ChargeRequest;
import com.pai.pms.payload.request.PaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class CheckoutController {
    Logger logger = LoggerFactory.getLogger(CheckoutController.class);
    PaymentRepository paymentRepository;

    public CheckoutController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @PostMapping("/checkout")
    public String checkout(@RequestParam String id, Model model) {
        Payment payment = paymentRepository.findById(Integer.valueOf(id)).orElseThrow();
        model.addAttribute("apartmentName", payment.getAgreement().getApartment().getName());
        model.addAttribute("userName", payment.getAgreement().getClient().getUser().getName());
        model.addAttribute("userLastName", payment.getAgreement().getClient().getUser().getLastName());
        model.addAttribute("login", payment.getAgreement().getClient().getUser().getLogin());
        model.addAttribute("paymentId", payment.getId());
        model.addAttribute("amount", (int)payment.getFee() * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.PLN);
        return "checkout";
    }
}
