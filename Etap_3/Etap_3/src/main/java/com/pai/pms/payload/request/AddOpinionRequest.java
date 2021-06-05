package com.pai.pms.payload.request;

import lombok.Data;

@Data
public class AddOpinionRequest {
    private int paymentId;
    private String opinion;

}
