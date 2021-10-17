package com.example.collectibledungeon.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collectible {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name, description, scale, material;
    private float height, price;
    private int code, stock;
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_license", nullable = false)
    private License license;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_producer", nullable = false)
    private Producer producer;
}
