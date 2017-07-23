package br.com.library.web;

import java.util.ArrayList;
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
	
//	int max = 4;
	
    @Autowired
    private LoanService loanService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Loan>> list() {
        ArrayList<Loan> loanList = new ArrayList<>();
        loanList = (ArrayList<Loan>) loanService.listAllLoan();
        return new ResponseEntity<List<Loan>>((List<Loan>) loanService.listAllLoan(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Loan> showLoan(@PathVariable Long id) {

        return new ResponseEntity<Loan>(loanService.getLoanById(id), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public String saveLoan(@RequestBody Loan loan) {
        Calendar today = Calendar.getInstance();
        loan.setLoanDate(today);
        today.add(Calendar.DATE, 7);
        loan.setReturnDate(today);
        loanService.saveLoan(loan);
//        if(loanService.findByUser(loan.getUser()) <= max) {
//        	return "O usuario nao pode pegar mais livros!";
//        }
        return "redirect:/loan/" + loan.getIdLoan();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    public String updateLoan(@RequestBody Loan loan) {

        // User newUser = new User();
        // newUser = userService.getUserById(user.getIdUser());
        // if (user.getNameUser() != null){
        // newUser.setNameUser(user.getNameUser());
        // }
        // if (user.getRegistrationNumberUser() != null){
        // newUser.setRegistrationNumberUs1e205 /48(user.getRegistrationNumberUser());
    	// }
        // if (user.getCourseNameUser() != null){
        // newUser.setCourseNameUser(user.getCourseNameUser());
        // }
        // if (user.getStudyPeriodUser() != null){
        // newUser.setStudyPeriodUser(user.getStudyPeriodUser());
        // }
        // userService.saveUser(newUser);
        // return "redirect:/user/update" + user.getIdUser();
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return "redirect:/loans";
    }
}
