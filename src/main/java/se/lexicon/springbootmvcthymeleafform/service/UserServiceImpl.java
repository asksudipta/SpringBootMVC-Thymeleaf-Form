package se.lexicon.springbootmvcthymeleafform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.springbootmvcthymeleafform.converter.UserConverter;
import se.lexicon.springbootmvcthymeleafform.model.dto.User;
import se.lexicon.springbootmvcthymeleafform.model.dto.UserView;
import se.lexicon.springbootmvcthymeleafform.model.entity.UserEntity;
import se.lexicon.springbootmvcthymeleafform.repository.UserRepository;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserView findById(int id) {
        if (id == 0) throw new IllegalArgumentException("Id is not valid");
        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();

            UserView userView = userConverter.toView(userEntity);

            return userView;
        } else {

            return null;
        }

    }

    @Override
    public UserView create(User userForm) {
        if (userForm == null) throw new IllegalArgumentException("User Form data is null");
        UserEntity convertedToEntity = new UserEntity(userForm.getName());
        UserEntity createdCategory = userRepository.save(convertedToEntity);
        UserView convertedToView = userConverter.toView(createdCategory);
        return convertedToView;
    }

    @Override
    public List<UserView> findAll() {
        List<UserEntity> entities = userRepository.findAll();
        return new ArrayList<>(userConverter.toViews(entities));

    }

    @Override
    public boolean delete(int id) {
        if (findById(id) != null){
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
