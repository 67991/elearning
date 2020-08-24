package com.myclass.elearning.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    // Mặc đinh lơp user chỉ có user name , password, role
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username,  password, authorities);
    }
}
