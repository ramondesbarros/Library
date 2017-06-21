package br.com.library.service;

import java.util.Date;

import br.com.library.domain.Loan;

public interface LoanService {
	
    Iterable <Loan> listAllLoan();
    
    Loan getLoanById(Long id);
    
    Loan saveLoan(Loan loan);
    
    void deleteLoan(Long id);
    
    Iterable <Loan> allLoanList(Date currentDate);
}
