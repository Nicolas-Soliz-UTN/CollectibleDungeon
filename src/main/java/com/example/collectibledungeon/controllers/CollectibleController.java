package com.example.collectibledungeon.controllers;

import com.example.collectibledungeon.entities.Collectible;
import com.example.collectibledungeon.services.CollectibleService;
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
}
