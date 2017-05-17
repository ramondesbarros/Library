package br.com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Magazine;
import br.com.library.integration.MagazineRepository;
import br.com.library.service.MagazineService;

@Service
public class MagazineServiceImpl implements MagazineService {
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	public Iterable<Magazine> listAllMagazine() {
		return magazineRepository.findAll();
	}

	@Override
	public Magazine getMagazineById(Long id) {
		return magazineRepository.findOne(id);
	}

	@Override
	public Magazine saveMagazine(Magazine magazine) {
		return magazineRepository.save(magazine);
	}

	@Override
	public void deleteMagazine(Long id) {
		magazineRepository.delete(id);
	}

}
