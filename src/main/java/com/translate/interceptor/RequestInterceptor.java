package com.translate.interceptor;

import com.translate.annotation.AllowAnonymous;
import com.translate.exception.AuthorizationException;
import com.translate.exception.SystemException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class RequestInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    private String token;

    public RequestInterceptor(String token) {
        this.token = token;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();

        if (method.getDeclaringClass().isAnnotationPresent(RestController.class) ||
                method.getDeclaringClass().isAnnotationPresent(RequestMapping.class)) {

            if (method.isAnnotationPresent(AllowAnonymous.class)) {
                return true;
            }

            if (method.isAnnotationPresent(GetMapping.class)
                    || method.isAnnotationPresent(PostMapping.class)
                    || method.isAnnotationPresent(PutMapping.class)
                    || method.isAnnotationPresent(DeleteMapping.class)) {

                String auth = request.getHeader("X-TOKEN-AUTH");

                if (StringUtils.isEmpty(auth) || !StringUtils.equals(auth, token)) {
                    throw new AuthorizationException("Bạn chưa đăng nhập. Xin vui lòng đăng nhập.", -1);
                }
            }
        }
        return true;
    }
}
