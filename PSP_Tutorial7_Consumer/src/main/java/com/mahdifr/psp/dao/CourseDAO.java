package com.mahdifr.psp.dao;

import java.util.List;

import com.mahdifr.psp.model.CourseModel;

public interface CourseDAO {
	CourseModel selectCourse (String id_course);
	
	List<CourseModel> selectAllCourses();
}