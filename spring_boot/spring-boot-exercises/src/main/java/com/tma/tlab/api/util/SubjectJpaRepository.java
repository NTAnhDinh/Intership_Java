package com.tma.tlab.api.util;

import com.tma.tlab.api.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SubjectJpaRepository extends JpaRepository<Subject, Long> {
}
