package se.lexicon.springbootmvcthymeleafform.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootmvcthymeleafform.model.dto.User;
import se.lexicon.springbootmvcthymeleafform.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {

    Optional<UserEntity> findByName(String name);

    List<UserEntity>findAll();

}
