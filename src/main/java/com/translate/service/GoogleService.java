package com.translate.service;

import com.translate.common.UserAgent;
import com.translate.dto.enums.Language;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

@Service
@Slf4j
public class GoogleService {

    public String translate(String input, Language languageFrom, Language languageTo) {

        String data = "translate,sl:%s,tl:%s,st:%s,id:%d,qc:true,ac:true,_id:tw-async-translate,_pms:s,_fmt:pc";

        try {
            Document document = Jsoup.connect("https://www.google.com.vn/async/translate?yv=3")
                    .userAgent(UserAgent.getUserAgent())
                    .timeout(30000)
                    .data("async", String.format(data, languageFrom.getName(), languageTo.getName(), URLEncoder.encode(input, "UTF-8"), new Date().getTime()))
                    .post();

            return StringUtils.trim(document.select("span#tw-answ-target-text").text());

        } catch (Exception ex) {
            log.error("GoogleService", ex);
        }

        return StringUtils.EMPTY;
    }
}
