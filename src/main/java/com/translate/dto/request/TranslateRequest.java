package com.translate.dto.request;

import com.translate.dto.enums.Language;
import lombok.Getter;
import lombok.Setter;

public class TranslateRequest {

    @Getter
    @Setter
    private String input;

    @Getter
    @Setter
    private Language languageFrom;

    @Getter
    @Setter
    private Language languageTo;
}
