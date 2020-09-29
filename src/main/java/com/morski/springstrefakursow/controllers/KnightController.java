package com.morski.springstrefakursow.controllers;

import com.morski.springstrefakursow.components.TimeComponent;
import com.morski.springstrefakursow.domain.Knight;
import com.morski.springstrefakursow.domain.PlayerInformation;
import com.morski.springstrefakursow.domain.repository.PlayerInformationRepository;
import com.morski.springstrefakursow.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    KnightService knightService;


    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = knightService.getAllKnights();
        PlayerInformation playerInformation = playerInformationRepository.getFirts();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        PlayerInformation playerInformation = playerInformationRepository.getFirts();
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        PlayerInformation playerInformation = playerInformationRepository.getFirts();
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getObjectName() + " " +error.getDefaultMessage());
            });
            return "knightform";
        } else {
            knightService.saveKnight(knight);
            return "redirect:/knights";
        }

    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}
