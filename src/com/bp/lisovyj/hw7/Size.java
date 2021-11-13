package com.bp.lisovyj.hw7;

public enum Size {
    XXS("Дитячий розмір", 32),
    XS("Дорослий розмір", 34),
    S("Дорослий розмір", 36),
    M("Дорослий розмір", 38),
    L("Дорослий розмір", 40);

    private final String description;
    private final int size;

    Size(String description, int euroSize) {
        this.description = description;
        size = euroSize;
    }

    String getDescription() {
        return description;
    }

    int getEuroSize() {
        return size;
    }
}
