package com.tma.tlab.api.repo_customQuery;

import com.tma.tlab.api.jpa.CommonJpaRepository;
import com.tma.tlab.api.model.Subject;

public interface SubjectJpaRepository extends CommonJpaRepository<Subject, Long>, SubjectJpaRepositoryCustom {

}
