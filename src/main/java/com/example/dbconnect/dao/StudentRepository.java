package com.example.dbconnect.dao;

import com.example.dbconnect.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//THIS IS RESPONSIBLE FOR DATA ACCESS
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1 ") //the Student is the Student class
    //In SQL the below code can be translated as SELECT * FROM student WHERE email = ?
    Optional<Student> findStudentByEmail(String email);

}
