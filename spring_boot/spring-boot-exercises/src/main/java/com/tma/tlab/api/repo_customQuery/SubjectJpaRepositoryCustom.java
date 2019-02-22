package com.tma.tlab.api.repo_customQuery;

import com.tma.tlab.api.model.Subject;

public interface SubjectJpaRepositoryCustom {
public Iterable<Subject> findAllWithDescription(String description);
}
