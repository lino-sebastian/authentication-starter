package com.post.meridiem.converter;

import com.post.meridiem.model.DBUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@Component
public class AuthUserConverter {

    public UserDetails dbUserToUserDetails(DBUser dbUser) {
        User.UserBuilder userBuilder = User.builder();
        ofNullable(dbUser).map(DBUser::getEmail).ifPresent(userBuilder::username);
        ofNullable(dbUser).map(DBUser::getPassword).ifPresent(userBuilder::password);
        userBuilder.authorities(emptyList());
        return userBuilder.build();
    }
}
