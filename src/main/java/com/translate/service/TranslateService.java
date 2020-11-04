package com.translate.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.common.UserAgent;
import com.translate.dto.enums.Language;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TranslateService {

    @Autowired
    private GoogleService googleService;

    @Autowired
    private BingService bingService;


    public String translate(String input, Language languageFrom, Language languageTo) {

        String data = googleService.translate(input, languageFrom, languageTo);

        if (StringUtils.isNotBlank(data)) {
            return data;
        }

        data = bingService.translate(input, languageFrom, languageTo);

        return data;
    }
}
