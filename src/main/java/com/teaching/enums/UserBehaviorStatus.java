package com.teaching.enums;

public enum UserBehaviorStatus {

    //type：用户行为类型：未知-0，浏览-1，收藏-2，加购物车-3，购买-4
    TYPE_DEFAULT(0),
    TYPE_BROWSE(1),
    TYPE_COLLECTION(2),
    TYPE_CART(3),
    TYPE_BUY(4),
    ;


    private int value;

    UserBehaviorStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
