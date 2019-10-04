package com.teaching.enums;

public enum CourseSectionStatus {

    //onsale：未上架（0）、上架（1）
    ONSALE_NO(0),
    ONSALE_YES(1),
    ;


    private int value;

    CourseSectionStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
