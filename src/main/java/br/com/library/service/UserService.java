package br.com.library.service;

import br.com.library.domain.User;

public interface UserService {

    Iterable<User> listAllUser();

    User getUserById(Long id);

    String saveUser(User user);

    void deleteUser(Long id);
}
