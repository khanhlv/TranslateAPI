package com.translate.dto.error;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private long timestamp;

    @Getter
    @Setter
    private String message;
}
