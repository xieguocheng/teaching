package com.teaching.enums;

public enum UserCourseSectionStatus {

    //status：状态：0-学习中；1-学习结束
    STATUS_STUDY(0),
    TYPE_STUDYEND(1),
    ;


    private int value;

    UserCourseSectionStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
