package com.example.dbconnect.dao;

import com.example.dbconnect.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
