package br.com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.domain.User;
import br.com.library.integration.UserRepository;
import br.com.library.service.UserService;
import br.com.library.validation.UserValidation;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidation userValidation;

    @Override
    public Iterable<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public String saveUser(User user) {

        User newUser = new User();
        newUser = getUserById(user.getIdUser());
        if (user.getNameUser() != null) {
            newUser.setNameUser(user.getNameUser());
        }
        if (user.getRegistrationNumberUser() != null) {
            newUser.setRegistrationNumberUser(user.getRegistrationNumberUser());
        }
        if (user.getCourseUser() != null) {
            newUser.setCourseUser(user.getCourseUser());
        }
        if (user.getStudyPeriodUser() != null) {
            newUser.setStudyPeriodUser(user.getStudyPeriodUser());
        }

        userRepository.save(user);
        boolean result = userValidation.dataValidation(user);
        if (result == false) {
            return "Error! Todos os dados devem estar preenchidos";
        }

        return "redirect:/user/" + user.getIdUser();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

}
