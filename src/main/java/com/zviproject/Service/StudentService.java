
package com.zviproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zviproject.common.entity.Student;
import com.zviproject.common.interfacee.IStudent;

@Service
public class StudentService {

	@Autowired
	IStudent iStudent;

	public void add(Student student) {
		iStudent.add(student);

	}

	public List<Student> informationAboutStudent() {
		return iStudent.informationAboutStudent();

	}

	public void removeById(int id) {
		iStudent.removeById(id);

	}

	public void updateStudentById(Integer id, Student student) {
		iStudent.updateStudentById(id, student);
	}

	public Student searchById(int id) {
		return iStudent.searchById(id);
	}

	public void test() {
		iStudent.test();
	}

	public List<Student> getStudentMarks(int mark) {
		return iStudent.getStudentMarks(mark);
	}

}
