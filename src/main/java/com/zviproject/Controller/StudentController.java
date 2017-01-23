package com.zviproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zviproject.Service.StudentService;
import com.zviproject.common.entity.Student;

@Configuration
@RequestMapping("/zvi/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * Get student by id from DB
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student searchById(@PathVariable int id) {
		return studentService.searchById(id);
	}

	/**
	 * Update information about bike in DB
	 * 
	 * @param bike
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		this.studentService.updateStudentById(id, student);
		return "Student was update";
	}

	/**
	 * Information about all student in DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public List<Student> informationAboutStudent() {
		return studentService.informationAboutStudent();
	}

	/**
	 * Remove student by id
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String removeById(@PathVariable("id") int id) {
		studentService.removeById(id);
		return "Student " + id + " was delete";
	}

	/**
	 * Create new student and add to DB
	 * 
	 * @param bike
	 * @return
	 */
	@Transactional(readOnly = false)
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String add(@RequestBody Student student) {
		studentService.add(student);
		return "student was created";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		studentService.test();
	}

	@RequestMapping(value = "/mark/{mark}", method = RequestMethod.GET)
	public List<Student> getStudentMarks(@PathVariable("mark") int mark) {
		return studentService.getStudentMarks(mark);
	}
}
