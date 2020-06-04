package com.morski.springstrefakursow;

public enum PersonUtils2 {

    INSTANCE;

    public final String operacja(Person person) {
        return person.imie.toUpperCase();
    }
}
