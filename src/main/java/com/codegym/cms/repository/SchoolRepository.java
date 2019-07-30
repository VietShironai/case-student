package com.codegym.cms.repository;

import com.codegym.cms.model.School;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {
}
