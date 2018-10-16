package com.interview.task.sfl.restaurant.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {
    ROLE_MANAGER, ROLE_WAITER;

    public String getAuthority() {
        return name();
    }
}
