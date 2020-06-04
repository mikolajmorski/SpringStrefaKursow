package com.morski.springstrefakursow.domain;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
