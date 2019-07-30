package com.codegym.cms.controller;

import com.codegym.cms.model.School;
import com.codegym.cms.model.Student;
import com.codegym.cms.service.SchoolService;
import com.codegym.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SchoolService schoolService;



    @GetMapping("/students")
    public ModelAndView listCustomers() {
        Iterable<Student> students = (Iterable<Student>) studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create-student")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView createStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", student);
        return modelAndView;

    }

    @GetMapping("/edit-student/{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error404");
        return modelAndView;

    }

    @PostMapping("/edit-student")
    public ModelAndView updateCUstomer(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("messenger", "Student updated");
        return modelAndView;

    }

    @GetMapping("/delete-student/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            ModelAndView modelAndView = new ModelAndView("/student/delete");
            modelAndView.addObject("student", student);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@ModelAttribute("student") Student student) {
        studentService.remove(student.getId());
        return "redirect:students";
    }
    @ModelAttribute("school")
    public Iterable<School> schools(){
        return schoolService.findAll();
    }

}



