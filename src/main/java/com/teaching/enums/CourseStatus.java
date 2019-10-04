package com.teaching.enums;

public enum CourseStatus {

    //0-默认，1-审核中，2-申请成功，3-申请失败
    STATUS_DEFULT(0),
    STATUS_VERIFY_ING(1),
    STATUS_VERIFY_SUCC(2),
    STATUS_VERIFY_FAIL(3),

    //level：课程级别：1-初级，2-中级，3-高级
    LEVEL_ONE(1),
    LEVEL_TWO(2),
    LEVEL_THERR(3),

    //【free：是否免费：0-否，1-是】
    FREE_NO(0),
    FREE_YES(1),

    //onsale：未上架（0）、上架（1）
    ONSALE_NO(0),
    ONSALE_YES(1),

    //recommend：未推荐（0）、推荐（1）
    RECOMMEND_NO(0),
    RECOMMEND_YES(1),


    ;

    private int value;

    CourseStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
