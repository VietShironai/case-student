package com.codegym.cms.repository;

import com.codegym.cms.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Page<Student> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
