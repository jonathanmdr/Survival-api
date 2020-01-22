package br.com.survival.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import br.com.survival.domain.model.User;
import lombok.Getter;

public class UserSystem extends org.springframework.security.core.userdetails.User {
	
    private static final long serialVersionUID = 1L;

    @Getter
    private User user;

    public UserSystem(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }

}
