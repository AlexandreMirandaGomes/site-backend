package br.com.xande.sitebackend.security;

import br.com.xande.sitebackend.entity.Authentication;
import br.com.xande.sitebackend.entity.User;
import br.com.xande.sitebackend.repository.TokenRepository;
import br.com.xande.sitebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Objects;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        Object token = authentication.getCredentials();
        Authentication auth = tokenRepository.findByToken((String) token);
        if (Objects.isNull(auth)) {
            throw new UsernameNotFoundException("Cannot find user");
        }
        return new org.springframework.security.core.userdetails.User(auth.getUser().getEmail(), auth.getUser().getPassword(),true,true,true,true, AuthorityUtils.createAuthorityList("user"));


    }
}
