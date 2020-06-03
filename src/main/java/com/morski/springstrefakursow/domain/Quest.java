package com.morski.springstrefakursow.domain;



public class Quest {

    private String decription;

    public Quest() {
        this.decription = "Uratuj ksiezniczke";
    }

    @Override
    public String toString() {
        return decription;
    }
}
