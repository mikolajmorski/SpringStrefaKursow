package com.morski.springstrefakursow.utils;

import java.util.Set;

public class Ids {

    static public int generateNewId(Set<Integer> keysSoFar) {
        if(keysSoFar.isEmpty()) {
            return 0;
        }
        else {
            Integer max = keysSoFar.stream().max((o1,o2) -> o1.compareTo(o2)).get();
            return max+1;
        }
    }
}
