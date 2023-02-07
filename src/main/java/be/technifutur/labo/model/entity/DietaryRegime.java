package be.technifutur.labo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class DietaryRegime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regime_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(name = "sandwich_dietaryRegimes",
            joinColumns = @JoinColumn(name = "regime_id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich_id"))
    private Set<Sandwich> sandwiches = new LinkedHashSet<>();
}
