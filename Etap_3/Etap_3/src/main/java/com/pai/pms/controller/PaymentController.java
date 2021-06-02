package com.pai.pms.controller;

import com.pai.pms.logic.service.PaymentService;
import com.pai.pms.payload.request.PaymentRequest;
import com.pai.pms.payload.response.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "client", method = RequestMethod.POST)
    @PreAuthorize("hasRole('CLIENT')")
    ResponseEntity<?> payYourBillsXD(@RequestBody @Valid PaymentRequest paymentRequest) {
        try {
            PaymentResponse response = paymentService.makePayment(paymentRequest);
            return ResponseEntity.created(URI.create("/" + response.getApartmentId())).body(response);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Prawdopodobnie wybrany przedział czasowy nie znajduje się w dostępnym przedziale czasowym dla wybranego apartamentu",
                    HttpStatus.BAD_REQUEST);
        }

    }
}
