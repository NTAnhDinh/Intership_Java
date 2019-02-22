package com.tma.tlab.api.controller;

import com.tma.tlab.api.model.Subject;
import com.tma.tlab.api.repo_customQuery.SubjectJpaRepositoryImpl;
import com.tma.tlab.api.util.SubjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
public class HelloWorldController {

    @Autowired
    private SubjectJpaRepository jpaRepository;
    @Autowired
    private SubjectJpaRepositoryImpl subjectJpaRepository;
    @Autowired
    private EntityManager entityManager;

    @RequestMapping("/")
    @ResponseBody
    public String hello1() {
        return "Hello World! Spring boot is so simple.";
    }

    @RequestMapping("/litSubject")
    public String index() {

        System.out.println("START testing jpa");
        List<Subject> subjectList = jpaRepository.findAll();
        for (Subject subject : subjectList) {
            System.out.println("ID = " + subject.getSubjectId());
            System.out.println("Description = " + subject.getDescription());
        }
        System.out.println("END testing jpa");

        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("START custom jpa");
        Iterable<Subject> subjects = subjectJpaRepository.findAllWithDescription("%UPDATE%");
        Iterator<Subject> subs = subjects.iterator();
        while (subs.hasNext()) {
            Subject s = subs.next();
            System.out.println("ID = " + s.getSubjectId());
            System.out.println("Description = " + s.getDescription());

        }
        System.out.println("END custom jpa");
        return "Hello !";
    }
}
