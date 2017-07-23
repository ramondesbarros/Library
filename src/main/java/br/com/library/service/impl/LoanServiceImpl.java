package br.com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.Loan;
import br.com.library.domain.User;
import br.com.library.integration.LoanRepository;
import br.com.library.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepository loanReposirory;
	
	@Override
	public Iterable<Loan> listAllLoan() {
		return loanReposirory.findAll();
	}

	@Override
	public Loan getLoanById(Long id) {
		return loanReposirory.findOne(id);
	}

	@Override
	public Loan saveLoan(Loan loan) {
		return loanReposirory.save(loan);
	}

	@Override
	public void deleteLoan(Long id) {
		loanReposirory.delete(id);
	}

	@Override
	public int findByUser(User user) {
		return loanReposirory.findByUser(user);
	}
}
