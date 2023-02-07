package be.technifutur.labo.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class SandwichIngredientID implements Serializable {

    private static final long serialVersionID = 1L;

    private long sandwichId;

    private long ingredientId;
}
