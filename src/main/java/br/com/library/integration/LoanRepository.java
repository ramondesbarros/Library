package br.com.library.integration;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long>{
	
	@Query("SELECT s FROM Loan s WHERE s.return_date < ?1")
	public Iterable<Loan> allLoanList(Date currentDate);
}
