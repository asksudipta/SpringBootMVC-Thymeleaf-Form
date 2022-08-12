package se.lexicon.springbootmvcthymeleafform.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootmvcthymeleafform.model.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    Optional<User> findByName(String name);

    List<User>findAll();

}
