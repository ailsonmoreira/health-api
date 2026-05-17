package com.healthcare.api.enums;

public enum Race {

    WHITE("White"),
    BLACK("Black"),
    BROWN("Brown"),
    YELLOW("Yellow"),
    INDIGENOUS("Indigenous");

    private final String description;

    Race(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
