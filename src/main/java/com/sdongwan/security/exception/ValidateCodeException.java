package com.sdongwan.security.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @Description
 * @Date 2019/12/22 12:01
 * @Created by sdongwan
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String name) {
        super(name);
    }
}
