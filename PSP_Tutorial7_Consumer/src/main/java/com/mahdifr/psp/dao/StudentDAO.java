package com.mahdifr.psp.dao;

import java.util.List;

import com.mahdifr.psp.model.StudentModel;

public interface StudentDAO {
	StudentModel selectStudent (String npm);
	
	List<StudentModel> selectAllStudents ();
}