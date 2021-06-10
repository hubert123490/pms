package com.pai.pms.payload.request;

import com.pai.pms.model.dto.AdditionalFieldWriteModel;
import com.pai.pms.model.dto.AddressWriteModel;
import com.pai.pms.model.dto.ApartmentWriteModel;
import lombok.Data;

@Data
public class AddApartmentRequest {
    private AddressWriteModel address;
    private AdditionalFieldWriteModel additionalField;
    private ApartmentWriteModel apartment;

}
