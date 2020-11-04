package com.translate.controller;

import com.translate.dto.GRequest;
import com.translate.dto.GResponse;
import com.translate.dto.enums.Language;
import com.translate.dto.request.TranslateRequest;
import com.translate.service.GoogleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/translate")
@Api(value = "/translate", description = "API Dich")
public class TranslateController {

    @Autowired
    private GoogleService googleService;

    @PostMapping("/")
    @ApiOperation(value = "Dich")
    public GResponse translate(@RequestBody GRequest<TranslateRequest> data) {
        return GResponse.build().data(googleService.translate(data.getData().getInput(), data.getData().getLanguageFrom(), data.getData().getLanguageTo()));
    }

    @GetMapping("/language")
    @ApiOperation(value = "Ngon ngu")
    public GResponse language() {
        return GResponse.build().data(Language.values());
    }

}
