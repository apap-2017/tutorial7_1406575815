package com.mahdifr.psp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahdifr.psp.model.CourseModel;
import com.mahdifr.psp.service.StudentService;

@RestController
@RequestMapping("/rest")
public class CourseRestController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/course/view/{id_course}")
	public CourseModel view(@PathVariable(value = "id_course") String id_course) {
		CourseModel course = studentService.selectCourse(id_course);
		return course;
	}
	
	@RequestMapping("/course/viewall")
	public List<CourseModel> viewAll() {
		List<CourseModel> course = studentService.selectAllCourses();
		return course;
	}
}
