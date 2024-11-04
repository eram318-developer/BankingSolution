package com.easybank.banksolution.config;

import com.easybank.banksolution.model.Customer;
import com.easybank.banksolution.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankSolutionProvider implements AuthenticationProvider {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        List<Customer> customerList = customerRepository.findByEmail(username);
        if(customerList.size()>0){
            if(passwordEncoder.matches(pwd,customerList.get(0).getPwd())){
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
                grantedAuthorityList.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username,pwd,grantedAuthorityList);
            }
            else {
                throw new BadCredentialsException("Invalid Password");
            }
        }
        else {
            throw new BadCredentialsException("No Registration With This Credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
