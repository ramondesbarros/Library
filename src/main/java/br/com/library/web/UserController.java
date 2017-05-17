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

import br.com.library.domain.User;
import br.com.library.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<User>> list() {
       
       return new ResponseEntity<List<User>>((List<User>) userService.listAllUser(), HttpStatus.FOUND);
    }
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> showUser(@PathVariable Long id) {
        
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.FOUND);
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST,  consumes = "application/json")
    public String saveUser(@RequestBody  User user) {
        
        userService.saveUser(user);
        return "redirect:/user/" + user.getIdUser();
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT,  consumes = "application/json")
    public String updateUser(@RequestBody  User user) {

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
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
 