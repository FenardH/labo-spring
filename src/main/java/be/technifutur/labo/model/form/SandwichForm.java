package be.technifutur.labo.model.form;

import be.technifutur.labo.model.entity.Ingredient;
import be.technifutur.labo.model.entity.Sandwich;
import be.technifutur.labo.repository.SandwichRepository;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Data
public class SandwichForm {
    private static SandwichRepository sandwichRepository;
    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @NotNull
    private List<Long> idDietaryRegimes;

//    @NotNull
//    private Map<Ingredient, Double> idIngredientsAndQuantities;

    public Sandwich toEntity(){
        Sandwich sandwich = new Sandwich();

        sandwich.setName(this.name);
        sandwich.setDescription(this.description);
        sandwich.setPrice(this.price);
        sandwich.setDietaryRegimes(new HashSet(
                idDietaryRegimes.stream()
                .map(id -> sandwichRepository.findIngredientById(id))
                .toList()));
//        idIngredientsAndQuantities.forEach(
//                (i, a) -> sandwichRepository.addSandwichIngredient(sandwich.getId(), i.getId(), a));

        return sandwich;
    }
}
