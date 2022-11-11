package com.example.dbconnect.service;
import com.example.dbconnect.dao.CourseRepository;
import com.example.dbconnect.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();

    }
    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }
}
