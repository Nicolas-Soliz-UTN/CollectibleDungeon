package com.example.collectibledungeon.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name, country;
    private boolean active;

    @OneToMany(mappedBy = "producer")
    private List<Collectible> collectibles;
}
