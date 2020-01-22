package br.com.survival.core.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.survival.domain.model.User;
import br.com.survival.domain.repository.UserRepository;

@Service
public class AppUserDetailService implements UserDetailsService {
	
    @Autowired
    private UserRepository userRepository;
	
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
        		.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos!"));
        return new UserSystem(user, getPermissions(user));
    }

    private Collection<? extends GrantedAuthority> getPermissions(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getPermissions().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getDescription().toUpperCase())));
        return authorities;
    }    

}
