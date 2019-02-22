package com.tma.tlab.api.repository;

import com.tma.tlab.api.model.User;
import com.tma.tlab.api.model.Subject;
import com.tma.tlab.api.util.SubjectJpaRepository;
import com.tma.tlab.api.util.UserJpaRepository;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class SubjectToUserRepository implements RelationshipRepositoryV2<User, Long, Subject, Long> {
    @Autowired
    private SubjectJpaRepository subjectJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public Class<User> getSourceResourceClass() {
        return User.class;
    }

    @Override
    public Class<Subject> getTargetResourceClass() {
        return Subject.class;
    }

    @Override
    public void setRelation(User user, Long targetId, String fieldName) {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subjectJpaRepository.getOne(targetId));
        user.setSubjects(subjects);
        userJpaRepository.save(user);
    }

    @Override
    public void setRelations(User user, Iterable<Long> targetIds, String fieldName) {
//        Set<Subject> subjects = new HashSet<Subject>();
//        subjects.addAll(subjectJpaRepository.findAllById(targetIds));
//        user.setSubjects(subjects);
//        userJpaRepository.save(user);
    }

    @Override
    public void addRelations(User user, Iterable<Long> targetIds, String fieldName) {
        List<Subject> subjects =  user.getSubjects();
        subjects.addAll(subjectJpaRepository.findAllById(targetIds));
        user.setSubjects(subjects);
        userJpaRepository.save(user);
    }

    @Override
    public void removeRelations(User user, Iterable<Long> targetIds, String fieldName) {
        List<Subject> subjects =  user.getSubjects();
        subjects.removeAll(subjectJpaRepository.findAllById(targetIds));
        user.setSubjects(subjects);
        userJpaRepository.save(user);
    }

    @Override
    public Subject findOneTarget(Long sourceId, String fieldName, QuerySpec querySpec) {
//        User user = userJpaRepository.getOne(sourceId);

        return null;
    }

    @Override
    public ResourceList<Subject> findManyTargets(Long sourceId, String fieldName, QuerySpec querySpec) {
        User user = userJpaRepository.getOne(sourceId);
        return querySpec.apply(user.getSubjects());
    }

}
