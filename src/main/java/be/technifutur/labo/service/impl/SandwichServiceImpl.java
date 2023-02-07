package be.technifutur.labo.service.impl;

import be.technifutur.labo.model.DTO.SandwichDTO;
import be.technifutur.labo.model.entity.Sandwich;
import be.technifutur.labo.model.form.SandwichForm;
import be.technifutur.labo.repository.SandwichRepository;
import be.technifutur.labo.service.SandwichService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SandwichServiceImpl implements SandwichService {
    private final SandwichRepository sandwichRepository;

    public SandwichServiceImpl(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    @Override
    public void create(SandwichForm form) {
        Sandwich sandwich = form.toEntity();

        sandwichRepository.save(sandwich);
    }

    @Override
    public SandwichDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<SandwichDTO> getAll() {
        return sandwichRepository.findAll().stream().map(SandwichDTO::from).toList();
    }

    @Override
    public void update(long id, Map<String, Object> params) {

    }

    @Override
    public void delete(long id) {

    }


}
