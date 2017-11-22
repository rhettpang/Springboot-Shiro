package com.test.shiro.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler( { UnauthorizedException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void processUnauthorizedException(NativeWebRequest request, HttpServletResponse response,UnauthorizedException e) {
        ServletWebRequest req = (ServletWebRequest)request;
        String url = req.getRequest().getRequestURI();
       // return "您无权访问接口："+url;
        try {
            String exception = e.getMessage();
            response.setHeader("Content-type", "text/html;charset=UTF-8");
//这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("You are not allow to invoke "+url+" method.方法");
            writer.println(exception);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
