package com.morski.springstrefakursow.controllers;


import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.Quest;
import com.morski.springstrefakursow.services.KnightService;
import com.morski.springstrefakursow.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;


    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);
        //Quest quest = new Quest("Testowe zadanie")
        return "assignQuest";
    }
}
