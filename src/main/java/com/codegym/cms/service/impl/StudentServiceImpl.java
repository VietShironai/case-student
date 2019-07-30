package com.codegym.cms.service.impl;

import com.codegym.cms.model.Student;
import com.codegym.cms.repository.StudentRepository;
import com.codegym.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentRepository studentRepository;


    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);

    }
}
