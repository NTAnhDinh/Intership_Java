package com.tma.tlab.api.repository;

import com.tma.tlab.api.model.User;
import com.tma.tlab.api.util.UserJpaRepository;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements ResourceRepositoryV2<User, Long>  {
    @Autowired
    private UserJpaRepository userJpaRepository;



    @Override
    public Class<User> getResourceClass() {
        return null;
    }

    @Override
    public User findOne(Long id, QuerySpec querySpec) {
        return null;
    }

    @Override
    public ResourceList<User> findAll(Iterable<Long> ids, QuerySpec querySpec) {
        return null;
    }

    @Override
    public <S extends User> S create(S entity) {
        return null;
    }

    @Override
    public ResourceList<User> findAll(QuerySpec querySpec) {
        return null;
    }

    @Override
    public User save(User obj) {

        return userJpaRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        User obj = userJpaRepository.getOne(id);
        this.userJpaRepository.delete(obj);
    }
}
