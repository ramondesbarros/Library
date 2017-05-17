package br.com.library.service;

import br.com.library.domain.Magazine;

public interface MagazineService {
	
    Iterable <Magazine> listAllMagazine();
    
    Magazine getMagazineById(Long id);
    
    Magazine saveMagazine(Magazine magazine);
    
    void deleteMagazine(Long id);
}
