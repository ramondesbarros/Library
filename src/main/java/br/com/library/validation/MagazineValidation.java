package br.com.library.validation;

import org.springframework.stereotype.Component;

import br.com.library.domain.Magazine;

@Component
public class MagazineValidation {
	
	public boolean dataValidation(Magazine magazine) {
		if(magazine.getTitleMagazine() == null || magazine.getTitleMagazine().isEmpty()) {
			return false;
		}
		if(magazine.getNumberMagazine() == null || magazine.getNumberMagazine().isEmpty()) {
			return false;
		}
		if(magazine.getPublicationMagazineDate() == null || magazine.getPublicationMagazineDate().isEmpty()) {
			return false;
		}
		if(magazine.getPublisherMagazine() == null || magazine.getPublisherMagazine().isEmpty()) {
			return false;
		}
		return true;
	}
}
