package com.example.collectibledungeon.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collectible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name, description, scale, material, image;
    private float height, price;
    private int code, stock;
    private boolean active = true;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_license", nullable = false)
    private License license;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_producer", nullable = false)
    private Producer producer;
}
