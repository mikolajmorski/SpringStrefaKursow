package com.morski.springstrefakursow;

public class PersonUtils {

    private static PersonUtils instance = null;

    private PersonUtils() {

    }

    public PersonUtils getIntstance() {
        if(instance == null){
            instance = new PersonUtils();
        }
        return instance;
    }



}
