package br.com.library.service;

import br.com.library.domain.Loan;
import br.com.library.domain.User;

public interface LoanService {
	
    Iterable <Loan> listAllLoan();
    
    Loan getLoanById(Long id);
    
    Loan saveLoan(Loan loan);
    
    void deleteLoan(Long id);  
    
    int findByUser(User user);
}
