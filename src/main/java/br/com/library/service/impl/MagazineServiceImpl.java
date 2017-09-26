package br.com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Magazine;
import br.com.library.integration.MagazineRepository;
import br.com.library.service.MagazineService;
import br.com.library.validation.MagazineValidation;

@Service
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;

    @Autowired
    private MagazineValidation magazineValidation;

    @Override
    public Iterable<Magazine> listAllMagazine() {
        return magazineRepository.findAll();
    }

    @Override
    public Magazine getMagazineById(Long id) {
        return magazineRepository.findOne(id);
    }

    @Override
    public String saveMagazine(Magazine magazine) {
        boolean result = magazineValidation.dataValidation(magazine);
        if (result == false) {
            return "Error! Todos os dados devem estar preenchidos";
        }

        magazineRepository.save(magazine);
        return "redirect:/magazine/" + magazine.getIdMagazine();
    }

    @Override
    public void deleteMagazine(Long id) {
        magazineRepository.delete(id);
    }

}
