package com.pai.pms.payload.response;

import com.pai.pms.model.dto.AgreementReadModel;
import com.pai.pms.model.dto.PaymentReadModel;
import com.pai.pms.model.entities.Agreement;
import com.pai.pms.model.entities.Payment;
import lombok.Data;

@Data
public class PaymentResponse {
    private PaymentReadModel payment;
    private AgreementReadModel agreement;
    private Integer apartmentId;

    public PaymentResponse(Payment payment, Agreement agreement, int apartmentId) {
        this.payment = new PaymentReadModel(payment);
        this.agreement = new AgreementReadModel(agreement);
        this.apartmentId = apartmentId;
    }


}
