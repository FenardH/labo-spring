package be.technifutur.labo.model.DTO;

import be.technifutur.labo.model.entity.DietaryRegime;
import be.technifutur.labo.model.entity.Ingredient;
import be.technifutur.labo.model.entity.Sandwich;
import be.technifutur.labo.repository.SandwichRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Data
@Builder
public class SandwichDTO {
    private static SandwichRepository sandwichRepository;

    private long id;

    private String name;

    private String description;

    private double price;

    private List<DietaryRegimeDTO> dietaryRegimes;

    private List<IngredientDTO> ingredients;

    @Data
    @Builder
    public static class DietaryRegimeDTO {

        private String name;

        private String description;
    }


    @Data
    @Builder
    public static class IngredientDTO {
        private String name;

        private double quantity;
    }

    public static SandwichDTO from(Sandwich entity){

        if( entity == null )
            return null;
        return SandwichDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .dietaryRegimes(
                        entity.getDietaryRegimes().stream()
                        .map(SandwichDTO::toDietaryRegimeDTO)
                        .toList())
                .ingredients(
                        sandwichRepository.findIngredientById(entity.getId()).stream()
                        .map(i -> toIngredientDTO(i, entity.getId()))
                        .toList())
                .build();

    }

    private static DietaryRegimeDTO toDietaryRegimeDTO(DietaryRegime entity) {
        if( entity == null )
            return null;
        return DietaryRegimeDTO.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    private static IngredientDTO toIngredientDTO(Ingredient entity, Long idSandwich) {
        if( entity == null )
            return null;
        return IngredientDTO.builder()
                .name(entity.getName())
                .quantity(sandwichRepository.findQuantityBySandwichIdAndIngredientId(entity.getId(), idSandwich))
                .build();
    }
}
