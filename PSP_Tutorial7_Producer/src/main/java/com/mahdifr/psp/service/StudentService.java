package com.mahdifr.psp.service;

import java.util.List;

import com.mahdifr.psp.model.CourseModel;
import com.mahdifr.psp.model.StudentModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);

    List<StudentModel> selectAllStudents ();

    void addStudent (StudentModel student);

    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
    
    CourseModel selectCourse (String id);
    
    List<CourseModel> selectAllCourses ();
}