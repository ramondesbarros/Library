package br.com.library.integration;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Loan;
import br.com.library.domain.User;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long>{
	
	@Modifying
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM loan WHERE study_period_usernDate = ?1")
	int findByUser(User user);
}
