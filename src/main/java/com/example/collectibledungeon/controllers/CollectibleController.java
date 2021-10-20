package com.example.collectibledungeon.controllers;

import com.example.collectibledungeon.entities.Collectible;
import com.example.collectibledungeon.services.CollectibleService;
import com.example.collectibledungeon.services.LicenseService;
import com.example.collectibledungeon.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CollectibleController {

    @Autowired
    CollectibleService collectibleService;

    @Autowired
    LicenseService licenseService;

    @Autowired
    ProducerService producerService;

    @GetMapping(value = "/")
    public String index(Model model) {
        try {
            List<Collectible> collectibles = collectibleService.findAllByActive();
            model.addAttribute("collectibles", collectibles);
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/details/{id}")
    public String collectibleDetails(Model model, @PathVariable("id") long id) {
        try {
            Collectible collectible = collectibleService.findAllByIdAndActive(id);
            model.addAttribute("collectible", collectible);
            return "views/details";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/search")
    public String collectibleSearch(Model model, @RequestParam(value = "query", required = false) String q) {
        try {
            List<Collectible> collectibles = collectibleService.findAllByName(q);
            model.addAttribute("collectibles", collectibles);
            return "views/search";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/crud")
    public String collectibleCrud(Model model) {
        try {
            List<Collectible> collectibles = collectibleService.findAll();
            model.addAttribute("collectibles", collectibles);
            return "views/crud";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/form/{id}")
    public String collectibleForm(Model model, @PathVariable("id") long id) {
        try {
            model.addAttribute("producers", producerService.findAll());
            model.addAttribute("licenses", licenseService.findAll());
            if (id == 0) {
                model.addAttribute("collectible", new Collectible());
            } else {
                model.addAttribute("collectible", collectibleService.findById(id));
            }
            return "views/form";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
