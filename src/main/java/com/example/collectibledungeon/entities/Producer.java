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
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name, country;
    private boolean active = true;

    @OneToMany(mappedBy = "producer")
    private List<Collectible> collectibles;
}
