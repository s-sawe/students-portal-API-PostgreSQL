package com.example.dbconnect.service;

import com.example.dbconnect.dao.StudentRepository;
import com.example.dbconnect.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
           throw new IllegalStateException("The Student Already Exists!!");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
                boolean exists = studentRepository.existsById(studentId);
                if(!exists){
                    throw new IllegalStateException("student with id" + studentId + "does not exist");

                }
                studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + studentId + "does not exist"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){ //if the name is not null,
            // and the length of the name is not equals to zero and the name supplied is not equal to the current one in the database
                    student.setName(name); //then set the name to this
                }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            //below checks whether the email has been taken
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);

        }
    }
}
/*new Student(
        1L,
        "Mariam",
        "mariam.jamal@gmail.com",
        LocalDate.of(2000, Month.JANUARY, 5),
        21
        )*/
