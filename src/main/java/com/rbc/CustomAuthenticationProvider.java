package com.rbc;

import org.springframework.security.core.AuthenticationException;

import org.springframework.security.core.Authentication;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Override
    public Authentication authenticate(Authentication authentication)  throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
         
        if (CustomAuthSystem(name, password)) {
        	
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
              name, password, new ArrayList<>());
        } else {
            return null;
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
    
    public boolean CustomAuthSystem(String uName, String pwd) {
    	if(uName.equalsIgnoreCase("userA") && uName.equalsIgnoreCase(pwd))
    		return true;
    	if(uName.equalsIgnoreCase("userB")||!uName.equalsIgnoreCase(pwd))
    		return true;
    	
    	return false;
    }

	

}
