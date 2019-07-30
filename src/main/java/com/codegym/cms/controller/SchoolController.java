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

@Controller
public class SchoolController {
    @Autowired
    private SchoolService schoolService;



    @GetMapping("/schools")
    public ModelAndView listCustomers() {
        Iterable<School> schools = (Iterable<School>) schoolService.findAll();
        ModelAndView modelAndView = new ModelAndView("/school/list");
        modelAndView.addObject("schools", schools);
        return modelAndView;
    }

    @GetMapping("/create-school")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("/school/create");
        modelAndView.addObject("school", new School());
        return modelAndView;
    }

    @PostMapping("/create-school")
    public ModelAndView createStudent(@ModelAttribute("school") School school) {
        schoolService.save(school);
        ModelAndView modelAndView = new ModelAndView("/school/create");
        modelAndView.addObject("school", school);
        return modelAndView;

    }

    @GetMapping("/edit-school/{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        School school = schoolService.findById(id);
        if (school != null) {
            ModelAndView modelAndView = new ModelAndView("/school/edit");
            modelAndView.addObject("school", school);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error404");
        return modelAndView;

    }

    @PostMapping("/edit-school")
    public ModelAndView updateCUstomer(@ModelAttribute("school") School school) {
        schoolService.save(school);
        ModelAndView modelAndView = new ModelAndView("/school/edit");
        modelAndView.addObject("school", school);
        modelAndView.addObject("messenger", "School updated");
        return modelAndView;

    }

    @GetMapping("/delete-school/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        School school = schoolService.findById(id);
        if (school != null) {
            ModelAndView modelAndView = new ModelAndView("/school/delete");
            modelAndView.addObject("school", school);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-school")
    public String deleteStudent(@ModelAttribute("school") School school) {
        schoolService.remove(school.getId());
        return "redirect:schools";
    }

}
