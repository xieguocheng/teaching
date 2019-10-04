package com.teaching.enums;

public enum ConstsSiteCarouselStatus {

    //type：0-轮播，1-免费课程，2-名师推荐
    TYPE_CAROUSEL(0),
    TYPE_FREE(1),
    TYPE_RECOMMEND(2),

    //status：0-正常使用，1-弃用
    STATUS_YES(0),
    STATUS_NO(1),
    ;


    private int value;

    ConstsSiteCarouselStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
