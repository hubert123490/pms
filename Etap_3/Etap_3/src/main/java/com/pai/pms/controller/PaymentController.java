package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentDetailService;
import com.pai.pms.logic.service.PaymentService;
import com.pai.pms.model.dto.AgreementWriteModel;
import com.pai.pms.model.dto.PaymentWriteModel;
import com.pai.pms.model.entities.Payment;
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
    ResponseEntity<Payment> payYourBillsXD(@RequestBody @Valid AgreementWriteModel agreementWriteModel,
                                                     @RequestBody @Valid PaymentWriteModel paymentWriteModel,
                                                     @PathVariable("id") int apartmentId) {

        Payment result = paymentService.makePayment(paymentWriteModel, agreementWriteModel, apartmentId);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
}
