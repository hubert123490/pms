package com.pai.pms.controller;

import com.pai.pms.logic.service.PaymentService;
import com.pai.pms.model.entities.Payment;
import com.pai.pms.payload.request.PaymentRequest;
import com.pai.pms.payload.response.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @RequestMapping("client")
    @PreAuthorize("hasRole('CLIENT')")
    ResponseEntity<PaymentResponse> payYourBillsXD(@RequestBody @Valid PaymentRequest paymentRequest) {
        Payment payment = paymentService.makePayment(paymentRequest.getPaymentWriteModel(), paymentRequest.getAgreementWriteModel()
                , paymentRequest.getApartmentId());
        PaymentResponse result = new PaymentResponse();
        result.setApartmentId(paymentRequest.getApartmentId());
        return ResponseEntity.created(URI.create("/" + result.getApartmentId())).body(result);
    }
}
