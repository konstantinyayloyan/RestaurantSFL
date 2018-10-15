package com.interview.task.sfl.restaurant.model.enums;

public enum UserType {

    MANAGER(1),
    WAITER(2);

    UserType(int value) {
        this.value = value;
    }

    public static UserType valueOf(int value) {
        for (UserType e : UserType.values()) {
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
