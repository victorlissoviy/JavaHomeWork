package com.bp.lisovyj.hw7v2;

public enum Size {
    XXS("дитячий розмір", 32),
    XS("дорослий розмір", 34),
    S("дорослий розмір", 36),
    M("дорослий розмір", 38),
    L("дорослий розмір", 40);

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
