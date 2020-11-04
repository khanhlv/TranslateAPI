package com.translate.dto.enums;

public enum Language {
    ENGLISH("en", "Tiếng anh"),
    JAPANESE("ja", "Tiếng nhật"),
    CHINESE_CN("zh-CN", "Tiếng trung (Giảm thể)"),
    CHINESE_TW("zh-TW", "Tiếng trung (Phổn thể)"),
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
