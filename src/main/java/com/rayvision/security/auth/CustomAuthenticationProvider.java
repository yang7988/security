package com.rayvision.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by xuyangyang on 2017/11/9.
 */
@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails
            , UsernamePasswordAuthenticationToken token) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        UserDetails userDetails;
        try
        {
            userDetails = customUserDetailsService.loadUserByUsername(userName);
        }
        catch (UsernameNotFoundException notFound)
        {
            logger.error("用户不存在：" + userName);
            throw notFound;
        }
        catch (Exception repositoryProblem)
        {
            logger.error(repositoryProblem);
            throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        if (userDetails == null)
        {
            throw new AuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
        }
        // 此处校验密码
        if (token.getCredentials() == null)
        {
            logger.error("校验异常：密码为空");
            throw new BadCredentialsException("校验异常：密码为空");
        }
        String presentedPassword = token.getCredentials().toString();
        if (!userDetails.getPassword().equals(presentedPassword))
        {
            logger.error("校验异常： 密码错误");
            throw new BadCredentialsException("校验异常： 密码错误");
        }
        token.setDetails(userDetails);
        return userDetails;
    }
}