package com.tma.tlab.api.repo_customQuery;

import com.tma.tlab.api.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SubjectJpaRepositoryImpl implements SubjectJpaRepositoryCustom {
   @Autowired
    EntityManager entityManager;
    @Override
    public Iterable<Subject> findAllWithDescription(String description) {
        TypedQuery<Object[]> query =entityManager.createNamedQuery("Subject.findAllWithDescription", Object[].class);
       query.setParameter("description", description);
        List results =query.getResultList();
        return results;
    }
}
