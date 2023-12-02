package lk.travel.authservice.security;

import lk.travel.authservice.dto.UserDTO;
import lk.travel.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AuthenticationConfig implements AuthenticationProvider {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        UserDTO userDTO = userService.searchByEmailUser(userName);
        if(userDTO !=null){
            if(passwordEncoder.matches(pwd,userDTO.getPwd())){
                return new UsernamePasswordAuthenticationToken(userName,pwd,getGrantedAuthority(userDTO.getRole().name()));
            }else{
            throw new BadCredentialsException("Invalid Password");
            }
        }else{
            throw new BadCredentialsException("Invalid User Name");
        }
    }
private Collection <GrantedAuthority> getGrantedAuthority(String role){
        List<GrantedAuthority> grantedAuthorityList=new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_"+role));
        return grantedAuthorityList;
}
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
