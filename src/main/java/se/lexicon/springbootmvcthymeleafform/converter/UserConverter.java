package se.lexicon.springbootmvcthymeleafform.converter;

import org.springframework.stereotype.Component;
import se.lexicon.springbootmvcthymeleafform.model.dto.UserView;
import se.lexicon.springbootmvcthymeleafform.model.entity.UserEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserConverter implements Converter <UserEntity, UserView>{


    @Override
    public UserView toView(UserEntity entity) {
        return new UserView(entity.getName(),entity.getEmail(), entity.getPassword(), entity.getGender(), entity.getNote(), entity.isMarried(), entity.getBirthdate());
    }

    @Override
    public UserEntity toEntity(UserView view) {
        return new UserEntity(view.getName(), view.getEmail(), view.getPassword(), view.getGender(), view.getGender(), view.isMarried(),view.getNote(), view.getPurpose());
    }

    @Override
    public Collection<UserView> toViews(Collection<UserEntity> entities) {
        return entities.stream().map(this::toView).collect(Collectors.toList());
    }

    @Override
    public Collection<UserEntity> toEntities(Collection<UserView> views) {
        return views.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
