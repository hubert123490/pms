package com.pai.pms.security.oauth2;

import com.pai.pms.model.entities.Client;
import com.pai.pms.model.entities.Role;
import com.pai.pms.model.entities.User;
import com.pai.pms.model.enums.AuthProvider;
import com.pai.pms.model.enums.ERole;
import com.pai.pms.model.repository.ClientRepository;
import com.pai.pms.model.repository.RoleRepository;
import com.pai.pms.model.repository.UserRepository;
import com.pai.pms.security.OAuth2UserInfo;
import com.pai.pms.security.OAuth2UserInfoFactory;
import com.pai.pms.security.exception.OAuth2AuthenticationProcessingException;
import com.pai.pms.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the com.pai.pms.security.oauth2.OAuth2AuthenticationFailureHandler
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<User> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
            if(!user.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                        user.getProvider() + " account. Please use your " + user.getProvider() +
                        " account to login.");
            }
            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }

        return UserDetailsImpl.build(user, oAuth2User.getAttributes());
    }

    private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        User user = new User();
        byte[] array = new byte[15]; // length is bounded by 15
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_CLIENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            user.setRoles(roles);
        user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        user.setProviderId(oAuth2UserInfo.getId());
        String[] nameCredentials = oAuth2UserInfo.getName().split(" ");
        user.setName(nameCredentials[0]);
        user.setLastName(nameCredentials[1]);
        user.setLogin(nameCredentials[0]+"_"+nameCredentials[1]);
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setPassword(encoder.encode(generatedString));
        Client client = new Client(0, 0, "Not given", user);
        User result = userRepository.save(user);
        clientRepository.save(client);
        return result;
    }

    private User updateExistingUser(User existingUser, OAuth2UserInfo oAuth2UserInfo) {
        String[] nameCredentials = oAuth2UserInfo.getName().split(" ");
        existingUser.setLogin(nameCredentials[0]+"_"+nameCredentials[1]);
        return userRepository.save(existingUser);
    }

}
