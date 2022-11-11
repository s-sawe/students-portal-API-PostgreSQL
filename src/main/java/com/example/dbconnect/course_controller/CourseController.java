package com.example.dbconnect.course_controller;

import com.example.dbconnect.entity.Course;
import com.example.dbconnect.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*@RequestMapping("/student")*/
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;

    }
    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course course){
        courseService.addNewCourse(course);
        return "Course Added Sucessfully !!";
    }
    @GetMapping("/course/getAll")
    public List<Course> getCourses() {

        return courseService.getCourses();
    }


}
