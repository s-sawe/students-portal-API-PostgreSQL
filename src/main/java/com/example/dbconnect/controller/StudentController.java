package com.example.dbconnect.controller;

import com.example.dbconnect.entity.Student;
import com.example.dbconnect.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {

        return studentService.getStudents();
    }

    @PostMapping()
    public String registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
        return "Student Registration Successful !!";

    }
    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){

        studentService.deleteStudent(studentId);
        return "Student De-Registration Successful!!";
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
                            studentService.updateStudent(studentId, name, email);
    }
}
