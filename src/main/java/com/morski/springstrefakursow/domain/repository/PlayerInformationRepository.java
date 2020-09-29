package com.morski.springstrefakursow.domain.repository;

import com.morski.springstrefakursow.domain.PlayerInformation;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;


    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {
        PlayerInformation pi = new PlayerInformation();
        em.persist(pi);
    }

    public PlayerInformation getFirts() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
