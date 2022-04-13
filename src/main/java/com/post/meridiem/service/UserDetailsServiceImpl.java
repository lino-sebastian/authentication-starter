package com.post.meridiem.service;

import com.post.meridiem.converter.AuthUserConverter;
import com.post.meridiem.repo.JPAUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JPAUserRepo jpaUserRepo;

    @Autowired
    private AuthUserConverter authUserConverter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authUserConverter.dbUserToUserDetails(jpaUserRepo.findByEmail(username));
    }
}
