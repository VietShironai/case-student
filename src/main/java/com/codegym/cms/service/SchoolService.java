package com.codegym.cms.service;

import com.codegym.cms.model.School;
import com.codegym.cms.model.Student;

public interface SchoolService {
    Iterable<School> findAll();
    School findById(Long id);
    void save(School school);
    void remove(Long id);
}
