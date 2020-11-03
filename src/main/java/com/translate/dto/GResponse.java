package com.translate.dto;

import lombok.Getter;
import lombok.Setter;

public class GResponse<T> {

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private T data;

    private GResponse() {

    }

    public GResponse data(T data) {
        this.status = 1;
        this.data = data;
        return this;
    }

    public GResponse error(T data) {
        this.status = 0;
        this.data = data;
        return this;
    }

    public static GResponse build() {
        return new GResponse<>();
    }
}
