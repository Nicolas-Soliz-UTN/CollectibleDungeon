package com.example.collectibledungeon.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Collectable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name, description, scale, material;
    private Double height, price, code, stock;
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_license", nullable = false)
    private License license;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_producer", nullable = false)
    private Producer producer;

}
