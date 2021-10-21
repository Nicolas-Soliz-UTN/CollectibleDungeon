package com.example.collectibledungeon.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name, founder, owner, country;
    private int year;
    private boolean active = true;

    @OneToMany(mappedBy = "license")
    private List<Collectible> collectibles;
}
