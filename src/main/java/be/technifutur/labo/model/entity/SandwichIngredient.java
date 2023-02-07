package be.technifutur.labo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Sandwich_ingredient")
@Getter
@Setter
public class SandwichIngredient {

    @Id
    @EmbeddedId
    private SandwichIngredientID id;

    @MapsId("sandwichId")
    @ManyToOne
    @JoinColumn(name = "sandwich_id")
    private Sandwich sandwich;

    @MapsId("ingredientId")
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(nullable = false)
    private double quantity;
}
