package com.codegym.cms.service;

import com.codegym.cms.model.Student;

public interface SchoolService {
    Iterable findAll();
    Student findById(Long id);
    void save(Student student);
    void remove(Long id);
}
