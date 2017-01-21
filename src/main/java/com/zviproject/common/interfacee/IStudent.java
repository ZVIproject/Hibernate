package com.zviproject.common.interfacee;

import java.util.List;
import java.util.Set;

import com.zviproject.common.entity.Mark;
import com.zviproject.common.entity.Student;

public interface IStudent {
	public void add(Student student);

	public List<Student> informationAboutStudent();

<<<<<<< HEAD
	public void removeById(int id_student);
=======
	public void removeById(int id);
>>>>>>> origin/developer

	public void updateStudentById(Integer id, Student student);

	public Student searchById(int id);

	public Set<Mark> getAllMarks(int id);

<<<<<<< HEAD
	public void test();

	public List<Student> getStudentMarks(int mark);

=======
>>>>>>> origin/developer
}
