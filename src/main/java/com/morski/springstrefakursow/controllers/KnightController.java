package com.morski.springstrefakursow.controllers;

import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.repository.KnightRepository;
import com.morski.springstrefakursow.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;


    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = knightService.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("hello", "Witaj swiecie");
        return "knights";
    }
}
