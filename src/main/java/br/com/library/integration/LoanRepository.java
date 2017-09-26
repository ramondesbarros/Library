package br.com.library.integration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.library.domain.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Long countByUserIdUser(Long id);

    @Query("select a from Loan a where a.returnDate < SYSDATE()")
    List<Loan> findByReturnDateLate();
}
