package com.morski.springstrefakursow.domain;

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
