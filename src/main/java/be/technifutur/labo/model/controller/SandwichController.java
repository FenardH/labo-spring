package be.technifutur.labo.model.controller;

import be.technifutur.labo.model.DTO.SandwichDTO;
import be.technifutur.labo.model.form.SandwichForm;
import be.technifutur.labo.service.impl.SandwichServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {
    private final SandwichServiceImpl sandwichService;

    public SandwichController(SandwichServiceImpl sandwichService) {
        this.sandwichService = sandwichService;
    }

    @PostMapping("/add")
    public void create(@RequestBody @Valid SandwichForm form) {
        sandwichService.create(form);
    }

    @GetMapping("/all")
    public List<SandwichDTO> getAll() {
        return sandwichService.getAll();
    }
}
