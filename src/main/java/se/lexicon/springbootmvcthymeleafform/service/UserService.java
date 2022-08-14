package se.lexicon.springbootmvcthymeleafform.service;

import se.lexicon.springbootmvcthymeleafform.model.dto.User;
import se.lexicon.springbootmvcthymeleafform.model.dto.UserView;

import java.util.List;

public interface UserService {

    UserView findById(int id);

    UserView create(User user);

    List<UserView> findAll();

    boolean delete(int id);

}
