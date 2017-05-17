package br.com.library.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.domain.Magazine;
import br.com.library.service.MagazineService;

@RestController
@RequestMapping("/magazine")
public class MagazineController {
	
	@Autowired
	private MagazineService magazineService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Magazine>> list() {
       
       return new ResponseEntity<List<Magazine>>((List<Magazine>) magazineService.listAllMagazine(), HttpStatus.FOUND);
    }
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Magazine> showMagazine(@PathVariable Long id) {
        
        return new ResponseEntity<Magazine>(magazineService.getMagazineById(id), HttpStatus.FOUND);
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST,  consumes = "application/json")
    public String saveMagazine(@RequestBody  Magazine magazine) {
        
        magazineService.saveMagazine(magazine);
        return "redirect:/magazine/" + magazine.getIdMagazine();
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT,  consumes = "application/json")
    public String updateMagazine(@RequestBody  Magazine magazine) {

//    	User newUser = new User();
//        newUser = userService.getUserById(user.getIdUser());
//        if (user.getNameUser() != null){
//            newUser.setNameUser(user.getNameUser());
//        }
//        if (user.getRegistrationNumberUser() != null){
//            newUser.setRegistrationNumberUser(user.getRegistrationNumberUser());
//        }
//        if (user.getCourseNameUser() != null){
//            newUser.setCourseNameUser(user.getCourseNameUser());
//        }
//        if (user.getStudyPeriodUser() != null){
//            newUser.setStudyPeriodUser(user.getStudyPeriodUser());
//        }
//        userService.saveUser(newUser);
//        return "redirect:/user/update" + user.getIdUser();
		return null;
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMagazine(@PathVariable Long id) {
        magazineService.deleteMagazine(id);
        return "redirect:/magazines";
    }
}
