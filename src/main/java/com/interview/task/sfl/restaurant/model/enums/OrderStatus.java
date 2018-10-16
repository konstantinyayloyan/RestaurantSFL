package com.interview.task.sfl.restaurant.model.enums;

public enum OrderStatus {

    OPEN(1) ,
    CANCELED(2) ,
    CLOSED(3);

    OrderStatus(int value){
        this.value = value;
    }

    public static OrderStatus valueOf(int value) {
        for (OrderStatus e : OrderStatus.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    private final int value;
}
