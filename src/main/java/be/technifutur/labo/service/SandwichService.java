package be.technifutur.labo.service;

import be.technifutur.labo.model.DTO.SandwichDTO;
import be.technifutur.labo.model.form.SandwichForm;

import java.util.List;
import java.util.Map;

public interface SandwichService {

    void create(SandwichForm form);

    SandwichDTO getOne(Long id);

    List<SandwichDTO> getAll();

    void update(long id, Map<String, Object> params);

    void delete(long id);
}
