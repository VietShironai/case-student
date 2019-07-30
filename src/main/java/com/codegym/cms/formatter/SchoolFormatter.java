package com.codegym.cms.formatter;

import com.codegym.cms.model.School;
import com.codegym.cms.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class SchoolFormatter implements Formatter<School> {
    private SchoolService schoolService;
    @Autowired
    public SchoolFormatter(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @Override
    public School parse(String text, Locale locale) throws ParseException {
        return schoolService.findById(Long.parseLong(text));
    }

    @Override
    public String print(School object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
