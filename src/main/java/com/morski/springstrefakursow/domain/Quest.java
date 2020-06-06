package com.morski.springstrefakursow.domain;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Quest {

    private String decription;

    public Quest(String decription) {
        this.decription = decription;
    }

    @Override
    public String toString() {
        return decription;
    }
}
