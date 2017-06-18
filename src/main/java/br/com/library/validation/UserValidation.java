package br.com.library.validation;

import org.springframework.stereotype.Component;

import br.com.library.domain.User;

@Component
public class UserValidation {
	
	public boolean dataValidation(User user) {
		
		if(user.getNameUser() == null || user.getNameUser().isEmpty()) {
			return false; 
		}
		
		if(user.getRegistrationNumberUser() == null || user.getRegistrationNumberUser().isEmpty()) {
			return false; 
		}
		
		if(user.getCourseNameUser() == null || user.getCourseNameUser().isEmpty()) {
			return false; 
		}
		
		if(user.getStudyPeriodUser() == null) {
			return false; 
		}
		
		return true;
	}
}
