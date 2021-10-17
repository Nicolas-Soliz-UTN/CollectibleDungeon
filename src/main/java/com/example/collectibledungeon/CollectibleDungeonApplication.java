package com.example.collectibledungeon;

import com.example.collectibledungeon.entities.Collectible;
import com.example.collectibledungeon.entities.License;
import com.example.collectibledungeon.entities.Producer;
import com.example.collectibledungeon.services.CollectibleService;
import com.example.collectibledungeon.services.LicenseService;
import com.example.collectibledungeon.services.ProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectibleDungeonApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CollectibleDungeonApplication.class, args);
    }
}
