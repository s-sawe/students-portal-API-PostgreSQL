package com.example.dbconnect.entity;
import javax.persistence.*;

@Entity
@Table
public class Course {

        @Id
        @SequenceGenerator(
                name = "course_sequence",
                sequenceName = "course_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "course_sequence"
        )

        private Long id;
        private String courseName;
        private String courseCode;


        @ManyToOne
        @JoinColumn(name = "student_id")
        private Student student;


        public Course(){

        }

        public Course(String courseName,
                      String studentName,
                      Long id) {
                this.courseName = courseName;
                this.courseCode = courseCode;
                this.id = id;
        }

        public Course(String courseName,
                      String studentName) {
                this.courseName = courseName;
                this.courseCode = courseCode;
        }

        public String getCourseName() {
                return courseName;
        }

        public void setCourseName(String courseName) {
                this.courseName = courseName;
        }

        public String getCourseCode() {
                return courseCode;
        }

        public void setCourseCode(String courseCode) {
                this.courseCode = courseCode;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Student getStudent() {
                return student;
        }

        public void setStudent(Student student) {
                this.student = student;
        }


        @Override
        public String toString() {
                return "Course{" +
                        "courseName='" + courseName + '\'' +
                        ", courseCode='" + courseCode + '\'' +
                        ", id='" + id + '\'' +
                        '}';
        }
}
