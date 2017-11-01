package com.mahdifr.psp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahdifr.psp.dao.StudentMapper;
import com.mahdifr.psp.model.CourseModel;
import com.mahdifr.psp.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
    }


    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        return studentMapper.selectAllStudents ();
    }


    @Override
    public void addStudent (StudentModel student)
    {
        studentMapper.addStudent (student);
    }


    @Override
    public void deleteStudent (String npm)
    {
    	log.info ("student " + npm + " deleted");
    	studentMapper.deleteStudent(npm);
    }


	@Override
	public void updateStudent(StudentModel student) {
		log.info ("student " + student.getNpm() + " updated");
		studentMapper.updateStudent(student);
	}


	@Override
	public CourseModel selectCourse(String id_course) {
		log.info ("select course with id_course {}", id_course);
		return studentMapper.selectCourse(id_course);
	}


	@Override
	public List<CourseModel> selectAllCourses() {
		log.info ("select all courses");
		return studentMapper.selectAllCourses();
	}
    

}