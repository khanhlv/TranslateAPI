package com.translate.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/context")
@Api(value = "/context", description = "API quan tri server")
public class ContextController implements ApplicationContextAware {

    private ApplicationContext context;

    @Value("${app.user}")
    private String user;

    @Value("${app.pass}")
    private String pass;

    @PostMapping("/shutdown")
    @ApiOperation(
            value = "Tat server API"
    )
    public void shutdown(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) {
        if (StringUtils.equals(user, username) && StringUtils.equals(pass, password)) {
            ((ConfigurableApplicationContext) context).close();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;
    }
}
