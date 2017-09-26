package br.com.library.service.impl;

import static br.com.library.constants.LibraryConstants.LOAN_LIMIT;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Loan;
import br.com.library.integration.LoanRepository;
import br.com.library.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanReposirory;

    @Override
    public List<Loan> listAllLoan() {
        return loanReposirory.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanReposirory.findOne(id);
    }

    @Override
    public String saveLoan(Loan loan) {

        if (countByUser(loan.getUser().getIdUser()) >= LOAN_LIMIT) {
            return "O livro não pode ser emprestado!";
        }
        Calendar today = Calendar.getInstance();
        Calendar returnDate = Calendar.getInstance();
        loan.setLoanDate(today);
        returnDate.add(Calendar.DAY_OF_YEAR, 7);
        loan.setReturnDate(returnDate);
        loanReposirory.save(loan);

        return "redirect:/loan/" + loan.getIdLoan();
    }

    @Override
    public void deleteLoan(Long id) {
        loanReposirory.delete(id);
    }

    @Override
    public Long countByUser(Long id) {
        return loanReposirory.countByUserIdUser(id);
    }

    @Override
    public List<Loan> findByReturnDateLate() {
        return loanReposirory.findByReturnDateLate();
    }
}
