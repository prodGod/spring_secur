package web.service.interfaces;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> findAll();
    User findById(long id);
    void update(long id, User user);
    void update(User user);
    void deleteById(long id);
    User findByLogin(String login);

}
