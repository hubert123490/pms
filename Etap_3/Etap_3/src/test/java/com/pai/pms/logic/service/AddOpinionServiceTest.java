package com.pai.pms.logic.service;

import com.pai.pms.model.entities.Agreement;
import com.pai.pms.model.entities.Client;
import com.pai.pms.model.entities.Payment;
import com.pai.pms.model.entities.User;
import com.pai.pms.model.repository.OpinionRepository;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.payload.request.AddOpinionRequest;
import com.pai.pms.payload.response.AddOpinionResponse;
import com.pai.pms.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AddOpinionServiceTest {

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
    @DisplayName("Should add opinion without errors")
    void addOpinion() throws IllegalAccessException {
        PaymentRepository paymentRepository = mock(PaymentRepository.class);
        OpinionRepository opinionRepository = mock(OpinionRepository.class);
        AddOpinionRequest addOpinionRequest = new AddOpinionRequest();
        addOpinionRequest.setOpinion("test opinion");
        addOpinionRequest.setPaymentId(3);
        Payment payment = new Payment();
        Agreement agreement = new Agreement();
        Client client = new Client();
        payment.setAgreement(agreement);
        agreement.setClient(client);
        User user = new User();
        client.setUser(user);
        user.setId(3);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();
        System.out.println(userImpl.getId());
        //SUT
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        AddOpinionService SUT = new AddOpinionService(paymentRepository, opinionRepository);

        //when
        AddOpinionResponse response = SUT.addOpinion(addOpinionRequest);

    }

}