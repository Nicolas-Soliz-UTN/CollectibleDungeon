package com.example.collectibledungeon.controllers;

import com.example.collectibledungeon.entities.Collectible;
import com.example.collectibledungeon.services.CollectibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
            return "";
        }
    }
}
