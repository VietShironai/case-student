package com.codegym.cms.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Student.class)
    private List<Student> students;


    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
    public  School(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
