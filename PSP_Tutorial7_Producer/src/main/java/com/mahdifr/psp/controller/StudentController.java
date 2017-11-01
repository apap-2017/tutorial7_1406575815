package com.mahdifr.psp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahdifr.psp.model.CourseModel;
import com.mahdifr.psp.model.StudentModel;
import com.mahdifr.psp.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController
{
    @Autowired
    StudentService studentDAO;

    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }

    @RequestMapping("/student/add")
    public String add ()
    {
        return "form-add";
    }

    @RequestMapping("/student/add/submit")
    public String addSubmit (
    		@RequestParam(value = "npm", required = false) String npm,
    		@RequestParam(value = "name", required = false) String name,
    		@RequestParam(value = "gpa", required = false) double gpa)
    {
    	StudentModel student = new StudentModel (npm, name, gpa, null);
    	studentDAO.addStudent (student);
    	
    	return "success-add";
    }

    @RequestMapping("/student/update/{npm}")
    public String update (Model model, @PathVariable(value = "npm") String npm)
    {
    	StudentModel archive = studentDAO.selectStudent(npm);
    	if(archive == null) {
    		return "not-found";
    	} else {
    		model.addAttribute("student", archive);
    		return "form-update";    		
    	}
    }

    /*
     * Update menggunakan parameter primitive types, bukan object
     */
//    @RequestMapping(value="/student/update/submit", method=RequestMethod.POST)
//    public String updateSubmit(@RequestParam(value = "npm", required = false) String npm,
//    		@RequestParam(value = "name", required = false) String name,
//    		@RequestParam(value = "gpa", required = false) double gpa)
//    {
//		StudentModel student = new StudentModel(npm, name, gpa);
//    	studentDAO.updateStudent(student);
//		return "success-update";
//    }
    
    /*
     * Update menggunakan parameter object
     * Jika menghandle POST dan GET sekaligus
     * @RequestMapping(value="/student/update/submit", method={RequestMethod.POST, RequestMethod.GET}) 
     */
    @RequestMapping(value="/student/update/submit", method=RequestMethod.POST)
    public String updateSubmit(@Valid StudentModel student, BindingResult bindingResult)
    {
    	if(bindingResult.hasErrors()) {
    		log.error("Error parameter {}", bindingResult.getAllErrors());
    		return "not-found";
    	} else {
    		studentDAO.updateStudent(student);
    		return "success-update";    		
    	}
    }
    

    @RequestMapping("/student/view")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }

    @RequestMapping("/student/view/{npm}")
    public String viewStudent (Model model,
            @PathVariable(value = "npm") String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/student/viewall")
    public String viewAllStudent (Model model)
    {
        List<StudentModel> students = studentDAO.selectAllStudents ();
        model.addAttribute ("students", students);

        return "viewall";
    }


    @RequestMapping("/student/delete/{npm}")
    public String delete (Model model, @PathVariable(value = "npm") String npm)
    {
    	StudentModel archive = studentDAO.selectStudent(npm);
    	if(archive == null) {
    		return "not-found";
    	} else {
    		studentDAO.deleteStudent(npm);
    		return "delete";    		
    	}
    }
    
    @RequestMapping("/course/view/{id_course}")
    public String viewCourse(Model model, @PathVariable(value="id_course") String id_course) {
    	CourseModel course = studentDAO.selectCourse(id_course);

        if (course != null) {
            model.addAttribute ("course", course);
            return "viewcourse";
        } else {
            return "course-not-found";
        }
    }
}