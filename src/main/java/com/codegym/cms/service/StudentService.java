package com.codegym.cms.service;

import com.codegym.cms.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> findAll(Pageable pageable);
    Student findById(Long id);
    void save(Student student);
    void remove(Long id);
    Page<Student> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
