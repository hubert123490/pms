package com.pai.pms.logic.service;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Image;
import com.pai.pms.model.repository.*;
import com.pai.pms.payload.request.BindImageRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BindImageServiceTest {

    @Test
    @DisplayName("should bind an image")
    void bindImage_shouldWorkAsIntended(){
        //given
        var mockApartmentRepository = mock(ApartmentRepository.class);
        var mockImageDbRepository = mock(ImageDbRepository.class);
        Apartment apartment = mock(Apartment.class);
        apartment.setId(1);
        Image image = mock(Image.class);
        image.setId(1L);
        BindImageRequest bindImageRequest = new BindImageRequest();
        bindImageRequest.setImageId(1L);
        bindImageRequest.setApartmentId(1);
        when(mockApartmentRepository.findById(1)).thenReturn(Optional.of(apartment));
        when(mockImageDbRepository.findById(1L)).thenReturn(Optional.of(image));
        //SUT
        BindImageService SUT = new BindImageService(mockImageDbRepository, mockApartmentRepository);

        //when
        Boolean result = SUT.bindImageToApartment(bindImageRequest);

        //then
        assertThat(result).isTrue();
    }
}