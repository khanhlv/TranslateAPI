package com.translate.controller;

import com.translate.annotation.AllowAnonymous;
import com.translate.dto.GResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "/", description = "API")
public class HomeController {

    @GetMapping("/")
    @AllowAnonymous
    @ApiOperation(value = "Home")
    public GResponse home() {
        return GResponse.build().data("OK");
    }
}
