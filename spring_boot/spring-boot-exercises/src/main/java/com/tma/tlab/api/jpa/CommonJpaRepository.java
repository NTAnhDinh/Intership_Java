package com.tma.tlab.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface CommonJpaRepository<T, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> ,JpaSpecificationExecutor<T>,JpaRepository<T, ID>  {
}
