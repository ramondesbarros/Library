package br.com.library.web;

import static br.com.library.constants.LibraryConstants.LOAN_LIMIT;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.domain.Loan;
import br.com.library.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Loan>> list() {
        // ArrayList<Loan> loanList = new ArrayList<>();
        // loanList = (ArrayList<Loan>) loanService.listAllLoan();
        return new ResponseEntity<List<Loan>>((List<Loan>) loanService.listAllLoan(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Loan> showLoan(@PathVariable Long id) {

        return new ResponseEntity<Loan>(loanService.getLoanById(id), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public String saveLoan(@RequestBody Loan loan) {
        Calendar today = Calendar.getInstance();
        Calendar returnDate = Calendar.getInstance();
        loan.setLoanDate(today);
        returnDate.add(Calendar.DAY_OF_YEAR, 7);
        loan.setReturnDate(returnDate);
        loanService.saveLoan(loan);
        if (loanService.countByUser(loan.getUser().getIdUser()) >= LOAN_LIMIT) {
            return "O livro não pode ser emprestado!";
        }

        return "redirect:/loan/" + loan.getIdLoan();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return "redirect:/loans";
    }
}
