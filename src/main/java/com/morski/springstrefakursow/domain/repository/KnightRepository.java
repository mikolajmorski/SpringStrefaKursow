package com.morski.springstrefakursow.domain.repository;

import com.morski.springstrefakursow.domain.Knight;
import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;
import java.util.Optional;


public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    void createKnight(Knight knight);

    Knight getKnightbyId(Integer id);

    default void updateKnight(int id, Knight knight) {

    }

}
