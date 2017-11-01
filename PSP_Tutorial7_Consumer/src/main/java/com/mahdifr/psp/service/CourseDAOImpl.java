package com.mahdifr.psp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mahdifr.psp.dao.CourseDAO;
import com.mahdifr.psp.model.CourseModel;

@Service
public class CourseDAOImpl implements CourseDAO{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CourseModel selectCourse(String id_course) {
		CourseModel course = restTemplate.getForObject("http://localhost:8080/rest/course/view/"+id_course, 
				CourseModel.class);
		return course;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseModel> selectAllCourses() {
		List<CourseModel> courses = restTemplate.getForObject("http://localhost:8080/rest/course/viewall", 
				List.class);
		return courses;
	}
	
	
}
