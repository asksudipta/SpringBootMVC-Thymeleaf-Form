package se.lexicon.springbootmvcthymeleafform.converter;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserConverter implements Converter{
    @Override
    public Object toView(Object entity) {
        return null;
    }

    @Override
    public Object toEntity(Object view) {
        return null;
    }

    @Override
    public Collection toViews(Collection entities) {
        return null;
    }

    @Override
    public Collection toEntities(Collection views) {
        return null;
    }
}
