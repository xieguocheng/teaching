package com.teaching.enums;

public enum CommonStatus {

    //0-未删除，1-已经删除
    DEL_NO(0),
    DEL_YES(1),

    ;

    private int value;

    CommonStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
