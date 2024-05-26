package com.easybank.banksolution.config;

import com.easybank.banksolution.model.Customer;
import com.easybank.banksolution.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankSolutionUserDetails implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
      String userName,password=null;
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        List<Customer> customerList = customerRepository.findByEmail(username);
        if(customerList.size()==0){
            throw new UsernameNotFoundException("User details not found"+username);
        }
        else{
            userName=customerList.get(0).getEmail();
            password=customerList.get(0).getPwd();
            //grantedAuthorities.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
            String customerRole = customerList.get(0).getRole();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(customerRole);
            grantedAuthorities.add(simpleGrantedAuthority);
        }
        return new User(userName,password,grantedAuthorities);
    }
}
