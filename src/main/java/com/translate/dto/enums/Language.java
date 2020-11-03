package com.translate.dto.enums;

public enum Language {
    JAPANESE("ja", "Tiếng nhật"),
    CHINESE_CN("zh-CN", "Tiếng trung (Giảm thể)"),
    CHINESE_TW("zh-TW", "Tiếng trung (Phổn thể)"),
    ENGLISH("en", "Tiếng anh"),
    VIETNAMESE("vi", "Tiếng việt");

    Language(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
