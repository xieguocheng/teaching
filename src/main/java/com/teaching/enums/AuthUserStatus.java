package com.teaching.enums;

public enum AuthUserStatus {

    //status：待审核（0），有效（1），无效（2）
    STATUS_DEFAULT(0),
    STATUS_YES(1),
    STATUS_NO(2),

    //gender：0-未知，1-男，2-女
    GENDER_DEFAULT(0),
    GENDER_MEN(1),
    GENDER_WOMEN(2),

        //teacher：0-未申请教师资格，1-审核中，2-申请成功，3-申请失败
    TEACHER_DEFAULT(0),
    TEACHER_DOING(1),
    TEACHER_SUCC(2),
    TEACHER_FAIL(3),
    ;


    private int value;

    AuthUserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
