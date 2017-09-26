package br.com.library.service;

import java.util.List;

import br.com.library.domain.Loan;

public interface LoanService {

    List<Loan> listAllLoan();

    Loan getLoanById(Long id);

    String saveLoan(Loan loan);

    void deleteLoan(Long id);

    Long countByUser(Long id);

    List<Loan> findByReturnDateLate();
}
