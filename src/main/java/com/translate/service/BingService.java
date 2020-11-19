package com.translate.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.translate.common.UserAgent;
import com.translate.dto.enums.Language;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BingService {

    public String translate(String input, Language languageFrom, Language languageTo) {
        //zh-Hans - Simple
        //zh-Hant - Traditional
        String from = languageFrom.getName();
        String to = languageTo.getName();

        if (languageFrom.equals(Language.CHINESE_CN)) {
            from = "zh-Hans";
        }

        if (languageTo.equals(Language.CHINESE_CN)) {
            to = "zh-Hans";
        }

        if (languageFrom.equals(Language.CHINESE_TW)) {
            from = "zh-Hant";
        }

        if (languageTo.equals(Language.CHINESE_TW)) {
            to = "zh-Hant";
        }

        try {
            Connection.Response response = Jsoup.connect("https://www.bing.com/ttranslatev3")
                    .userAgent(UserAgent.getUserAgent())
                    .timeout(30000)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("fromLang", from)
                    .data("text", URLEncoder.encode(input, "UTF-8"))
                    .data("to", to)
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute();

            List<Map> listBody = new Gson().fromJson(response.body(), List.class);
            Map<String, Object> mapData = listBody.get(0);
            List<Map> dataList = (List)mapData.get("translations");
            Map<String, Object> mapDataList = dataList.get(0);

            return StringUtils.trim((String)mapDataList.get("text"));

        } catch (Exception ex) {
            log.error("BingService", ex);
        }

        return StringUtils.EMPTY;
    }
}
