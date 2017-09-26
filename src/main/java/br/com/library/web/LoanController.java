package br.com.library.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.domain.Loan;
import br.com.library.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Loan> getAllLoans() {
        return loanService.listAllLoan();
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Loan> showLoan(@PathVariable Long id) {
        return new ResponseEntity<Loan>(loanService.getLoanById(id), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public String saveLoan(@RequestBody Loan loan) {
        return loanService.saveLoan(loan);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return "redirect:/loans";
    }

    @RequestMapping(value = "/late", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Loan> getListLate() {
        return loanService.findByReturnDateLate();
    }
}
