package com.pai.pms.payload.request;

import com.pai.pms.model.dto.AgreementWriteModel;
import com.pai.pms.model.dto.PaymentWriteModel;

public class PaymentRequest {
    private PaymentWriteModel paymentWriteModel;
    private AgreementWriteModel agreementWriteModel;
    private int apartmentId;

    public PaymentWriteModel getPaymentWriteModel() {
        return paymentWriteModel;
    }

    public void setPaymentWriteModel(PaymentWriteModel paymentWriteModel) {
        this.paymentWriteModel = paymentWriteModel;
    }

    public AgreementWriteModel getAgreementWriteModel() {
        return agreementWriteModel;
    }

    public void setAgreementWriteModel(AgreementWriteModel agreementWriteModel) {
        this.agreementWriteModel = agreementWriteModel;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }
}
