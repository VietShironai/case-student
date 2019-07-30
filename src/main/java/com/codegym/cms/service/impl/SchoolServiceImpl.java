package com.codegym.cms.service.impl;

import com.codegym.cms.model.School;
import com.codegym.cms.model.Student;
import com.codegym.cms.repository.SchoolRepository;
import com.codegym.cms.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;

public class SchoolServiceImpl implements SchoolService {
    @Autowired
    public SchoolRepository schoolRepository;
    @Override
    public Iterable findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findOne(id);
    }

    @Override
    public void save(School school) {
        schoolRepository.save(school);

    }

    @Override
    public void remove(Long id) {
        schoolRepository.delete(id);

    }
}
