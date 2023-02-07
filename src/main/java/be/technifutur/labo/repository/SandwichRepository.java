package be.technifutur.labo.repository;

import be.technifutur.labo.model.entity.Ingredient;
import be.technifutur.labo.model.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {

    @Query("SELECT si.ingredient FROM SandwichIngredient si WHERE si.sandwich.id = :id")
    List<Ingredient> findIngredientById(Long id);

    @Query("SELECT si.quantity FROM SandwichIngredient si WHERE si.sandwich.id = :idSandwich AND si.ingredient.id = :idIngredient")
    double findQuantityBySandwichIdAndIngredientId(Long idSandwich, Long idIngredient);

    @Query("UPDATE SandwichIngredient si " +
           "SET si.sandwich.id = :idSandwich, si.ingredient.id = :idIngredient, si.quantity = :quantity")
    void addSandwichIngredient(Long idSandwich, Long idIngredient, double quantity);
}
