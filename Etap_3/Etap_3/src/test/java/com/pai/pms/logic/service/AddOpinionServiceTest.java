package com.pai.pms.logic.service;

import com.pai.pms.model.entities.*;
import com.pai.pms.model.repository.OpinionRepository;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.payload.request.AddOpinionRequest;
import com.pai.pms.payload.response.AddOpinionResponse;
import com.pai.pms.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AddOpinionServiceTest {

    //setting security context
    @BeforeAll
    static void beforeAll() {
        Authentication authentication = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return new UserDetailsImpl(1, "test@mail.com", "123456789", List.of(new SimpleGrantedAuthority("CLIENT")));
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return String.valueOf(1);
            }
        };
        // Mockito.whens() for your authorization object
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    @DisplayName("Should add opinion without errors, user hasn't add opinion for certain apartment yet")
    void addOpinion_FirstOpinion_WorksAsExpected() throws IllegalAccessException {
        //given
        AddOpinionRequest addOpinionRequest = initRequest("test opinion", 1);
        PaymentRepository paymentRepository = mock(PaymentRepository.class);
        OpinionRepository opinionRepository = mock(OpinionRepository.class);

        Payment payment = new Payment();
        Agreement agreement = new Agreement();
        Client client = new Client();
        User user = new User();
        Apartment apartment = new Apartment();

        //set required data
        payment.setAgreement(agreement);
        agreement.setApartment(apartment);
        agreement.setClient(client);
        client.setUser(user);
        client.setOpinions(List.of());
        user.setId(1);

        //get user from security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        //SUT
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        AddOpinionService SUT = new AddOpinionService(paymentRepository, opinionRepository);

        //when
        String expectedText = addOpinionRequest.getOpinion();
        LocalDate expectedDate = LocalDate.now();
        AddOpinionResponse response = SUT.addOpinion(addOpinionRequest);

        //then
        assertThat(response.getText()).isEqualTo(expectedText);
        assertThat(response.getPublishedDate()).isAfterOrEqualTo(expectedDate);
    }

    @Test
    @DisplayName("Should add opinion without errors, replacing previous opinion")
    void addOpinion_SecondOpinion_ShouldReplaceDateAndTextOfPreviousOpinion() throws IllegalAccessException {
        //given
        AddOpinionRequest addOpinionRequest = initRequest("test opinion", 1);
        PaymentRepository paymentRepository = mock(PaymentRepository.class);
        OpinionRepository opinionRepository = mock(OpinionRepository.class);

        Payment payment = new Payment();
        Agreement agreement = new Agreement();
        Client client = new Client();
        User user = new User();
        Apartment apartment = new Apartment();
        Opinion opinion = new Opinion();
        opinion.setPublishedDate(LocalDate.of(2021, 03, 22));
        opinion.setText("test text");
        opinion.setApartment(apartment);
        opinion.setClient(client);
        opinion.setUser(user);

        //set required data
        payment.setAgreement(agreement);
        agreement.setApartment(apartment);
        agreement.setClient(client);
        client.setUser(user);
        client.setOpinions(List.of(opinion));
        user.setId(1);

        //get user from security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        //SUT
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        AddOpinionService SUT = new AddOpinionService(paymentRepository, opinionRepository);

        //when
        AddOpinionResponse response = SUT.addOpinion(addOpinionRequest);

        //then
        assertThat(opinion.getText()).isEqualTo(response.getText());
        assertThat(response.getPublishedDate()).isEqualTo(opinion.getPublishedDate());
    }

    @Test
    @DisplayName("Should throw IllegalAccessException")
    void addOpinion_ShouldThrowIllegalAccessException() {
        //given
        AddOpinionRequest addOpinionRequest = initRequest("test opinion", 1);
        PaymentRepository paymentRepository = mock(PaymentRepository.class);
        OpinionRepository opinionRepository = mock(OpinionRepository.class);

        Payment payment = new Payment();
        Agreement agreement = new Agreement();
        Client client = new Client();
        User user = new User();
        Apartment apartment = new Apartment();
        Opinion opinion = new Opinion();
        opinion.setPublishedDate(LocalDate.of(2021, 03, 22));
        opinion.setText("test text");
        opinion.setApartment(apartment);
        opinion.setClient(client);
        opinion.setUser(user);

        //set required data
        payment.setAgreement(agreement);
        agreement.setApartment(apartment);
        agreement.setClient(client);
        client.setUser(user);
        client.setOpinions(List.of(opinion));
        //user id should be different from that from security context
        user.setId(3);

        //get user from security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        //SUT
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        AddOpinionService SUT = new AddOpinionService(paymentRepository, opinionRepository);

        //when
        var exception = catchThrowable(() -> SUT.addOpinion(addOpinionRequest));

        //then
        assertThat(exception).hasMessageStartingWith("Klient nie kupił").isInstanceOf(IllegalAccessException.class);
    }

    private AddOpinionRequest initRequest(String text, int paymentId){
        AddOpinionRequest request = new AddOpinionRequest();
        request.setOpinion(text);
        request.setPaymentId(paymentId);
        return request;
    }

}