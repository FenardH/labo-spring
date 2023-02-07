package be.technifutur.labo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sandwich_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "sandwiches")
    private Set<DietaryRegime> dietaryRegimes = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "sandwiches")
    private Set<Basket> baskets = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "sandwiches")
    private Set<Order> orders = new LinkedHashSet<>();
}
