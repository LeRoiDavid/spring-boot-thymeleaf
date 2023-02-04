package com.lrd.webspringthymeleaf.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lrd.webspringthymeleaf.entities.Professeur;
import com.lrd.webspringthymeleaf.services.ProfesseurService;

@Controller
public class ProfesseurController {
    Logger logger = LoggerFactory.getLogger(ProfesseurController.class);
    String appName = "SPRING-THYMELEAF";

    public final ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @GetMapping("/professeurs/add")
    public String add(Professeur professeur, Model model) {
        return "professeurs/create-professeur";
    }

    @PostMapping(value = "/professeurs/create")
    public String create(Professeur professeur) {
        professeurService.create(professeur);
        logger.info("{} : professeur create : {}", appName, professeur);
        return "redirect:/professeurs/getAll";
    }

    @GetMapping(value = "/professeurs/getAll")
    public String getAll(Model map) {
        List<Professeur> professeurs = professeurService.getAll();
        map.addAttribute("professeurs", professeurs);
        logger.info("{} - professeur list : {}", appName, professeurs);
        return "professeurs/list-professeur";
    }

    @GetMapping("/professeurs/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Professeur professeur = this.professeurService.getOne(id);
        logger.info(" {} - start editing professeur : {}", appName, professeur);

        model.addAttribute("professeur", professeur);
        return "professeurs/update-professeur";
    }

    @PostMapping("/professeurs/update/{id}")
    public String update(@PathVariable int id, Professeur professeur) {
        System.out.println(professeur);
        System.out.println("id => " + id);
        this.professeurService.update(id, professeur);
        logger.info(" {} - updates professeur : {}", appName, professeur);

        return "redirect:/professeurs/getAll";
    }

    @GetMapping("/professeurs/changeStatus/{id}")
    public String changeStatus(@PathVariable int id, Professeur professeur) {
        this.professeurService.changeStatus(id);
        logger.info(" {} - change professeur status of : {}", appName, professeur);
        return "redirect:/professeurs/getAll";
    }

}
