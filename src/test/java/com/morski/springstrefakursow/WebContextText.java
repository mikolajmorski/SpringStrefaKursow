package com.morski.springstrefakursow;


import com.morski.springstrefakursow.controllers.QuestController;
import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.PlayerInformation;
import com.morski.springstrefakursow.domain.Quest;
import com.morski.springstrefakursow.services.KnightService;
import com.morski.springstrefakursow.services.QuestService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class WebContextText {


    @Mock
    KnightService knightService;

    @Mock
    QuestService questService;

    @Mock
    PlayerInformation playerInformation;

    @InjectMocks
    QuestController questController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(questController).build();
    }

    @Test
    public void testCheckQuest() throws Exception {


        mockMvc.perform(get("/checkQuests"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/knights"));
    }

    @Test
    public void contextLoads() {
    }
}
