package com.pai.pms.controller;

import com.pai.pms.logic.service.PaymentDetailService;
import com.pai.pms.model.dto.PaymentDetailReadModel;
import com.pai.pms.model.dto.PaymentReadModel;
import com.pai.pms.payload.request.PaymentRequest;
import com.pai.pms.payload.response.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/payment/")
public class PaymentDetailController {
    private final PaymentDetailService paymentDetailService;

    public PaymentDetailController(PaymentDetailService paymentDetailService) {
        this.paymentDetailService = paymentDetailService;
    }

    @RequestMapping(value = "read", method = RequestMethod.GET)
    @PreAuthorize("hasRole('CLIENT')")
    ResponseEntity<List<PaymentDetailReadModel>> readAllClientPayments() {
        return ResponseEntity.ok(paymentDetailService.readAllClientPayments());
    }
}
