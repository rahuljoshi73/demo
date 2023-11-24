package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@RestController
@RequestMapping(path = "/student-demo")
public class StudentController {

    @Autowired 
    private StudentRepo studentRepo;
    @PostMapping(path ="/add")
    public @ResponseBody Student addnewstd(@RequestParam String name,@RequestParam String email){
        Student springStudent = new Student();
        springStudent.setName(name);
        springStudent.setEmail(email);
        studentRepo.save(springStudent);
        return springStudent;
        
    }
    

    @GetMapping("/all")
    public List<Student> getStudent(){
        return studentRepo.findAll();
    }
}
