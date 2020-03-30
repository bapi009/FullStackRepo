package com.vmware.calculate.service.impl;

import com.vmware.calculate.model.VmWareEmployee;
import com.vmware.calculate.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        VmWareEmployee user = new VmWareEmployee();
        user.setUsername("User");
        user.setPassword("Password");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return new User(user.getUsername(), encoder.encode(user.getPassword()),
                new ArrayList<>());
    }
}
