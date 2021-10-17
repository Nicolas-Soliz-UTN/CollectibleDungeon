package com.example.collectibledungeon;

import com.example.collectibledungeon.entities.Collectible;
import com.example.collectibledungeon.entities.License;
import com.example.collectibledungeon.entities.Producer;
import com.example.collectibledungeon.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectibleDungeonApplication {

    public static void main(String[] args) {

        License license1 = License.builder().name("DC Comics").founder("Malcolm Wheeler-Nicholson").owner("WarnerMedia").year(1934).country("United States").active(true).build();
        License license2 = License.builder().name("Marvel Comics").founder("Martin Goodman").owner("The Walt Disney Company").year(1939).country("United States").active(true).build();

        Producer producer1 = Producer.builder().name("S.H. Figuarts").country("Australia").active(true).build();
        Producer producer2 = Producer.builder().name("Iron Studios").country("United Kingdom").active(true).build();

        Collectible collectible1 = Collectible.builder().name("Batman Delux Art").code(11223344).description("Directly from the 2008 film Batman: The Dark Knight, directed by Christopher Nolan and played by Christian Bale.").active(true).height(12).material("Polystone").scale("1:10").price(150).stock(25).license(license1).producer(producer2).build();
        Collectible collectible2 = Collectible.builder().name("Black Widow BDS Art Scale").code(66778899).description("Scarlett Johansson plays Natasha Romanoff also known as Black Widow in the Marvel Cinematic Universe.").active(true).height(10).material("Polystone").scale("1:10").price(115).stock(19).license(license2).producer(producer1).build();

        SpringApplication.run(CollectibleDungeonApplication.class, args);
    }
}
