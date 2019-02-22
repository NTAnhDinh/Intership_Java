package com.tma.tlab.api.repository;

import com.tma.tlab.api.model.Subject;
import com.tma.tlab.api.util.SubjectJpaRepository;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.*;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectRepositoryImpl implements  ResourceRepositoryV2<Subject, Long>  {
    @Autowired
    private SubjectJpaRepository jpaRepository;




    @Override
    public Class<Subject> getResourceClass() {
        return null;
    }

    @Override
    public Subject findOne(Long id, QuerySpec querySpec) {

        return jpaRepository.getOne(id);
    }

    @Override
    public ResourceList<Subject> findAll(QuerySpec querySpec) {
        ResourceList<Subject> list = new DefaultResourceList<Subject>(new DefaultPagedMetaInformation(), new DefaultPagedLinksInformation());
        List<Subject> subjects = jpaRepository.findAll();
        querySpec.apply(subjects, list);
        return list;

    }

    @Override
    public ResourceList<Subject> findAll(Iterable<Long> ids, QuerySpec querySpec) {
        return querySpec.apply(jpaRepository.findAllById(ids));
    }

    @Override
    public <S extends Subject> S create(S entity) {
        return save(entity);
    }

    @Override
    public <S extends Subject> S  save(S obj) {

        return jpaRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        Subject obj = jpaRepository.getOne(id);
        this.jpaRepository.delete(obj);
    }

}
