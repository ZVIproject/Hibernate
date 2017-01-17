package com.zviproject.common.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.zviproject.common.entity.Student;
import com.zviproject.common.interfacee.IStudent;
import com.zviproject.common.persistence.HibernateUtil;

@Repository
public class StudentDao implements IStudent {

	public Session createSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session;
	}

	@Override
	public void add(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

	}

	@Override
	public List<Student> informationAboutStudent() {
		Session session = createSession();
		final String hql = "SELECT s FROM Student s";
		Query query = session.createQuery(hql);
		ArrayList<Student> student = (ArrayList<Student>) query.list();
		session.getTransaction().commit();
		if (session.isOpen())
			session.close();

		return student;
	}

	@Override
	public void removeById(int id) {
		Session session = createSession();
		Student studnetDelete = (Student) session.get(Student.class, id);
		session.delete(studnetDelete);
		session.getTransaction().commit();
		if (session.isOpen())
			session.close();

	}

	@Override
	public void updateStudentById(Integer id, Student student) {
		Session session = createSession();
		Student studentUpdate = (Student) session.get(Student.class, id);
		studentUpdate.setName(student.getName());
		studentUpdate.setSurname(student.getSurname());
		session.update(studentUpdate);
		session.getTransaction().commit();
		if (session.isOpen())
			session.close();
	}

	@Override
	public Student searchById(int id) {
		Session session = createSession();

		Student student = (Student) session.get(Student.class, id);

		Query q = session.createQuery("select r from Student r where r.id=:id");
		q.setParameter("id", id);
		List<Student> stLst = q.list();
		System.out.println("size: " + stLst.size());
		stLst.forEach(s -> {
			System.out.println(s.getMarks().size());
		});
		// Set<Mark> detailedStudent = new HashSet<>();
		// Mark mark = new Mark();
		// while (mark != null) {
		// mark = (Mark) session.get(Mark.class, id);

		// detailedStudent.add(mark);
		// }
		// student.setMarks(detailedStudent);

		// student.addMarks(mark);
		// student.setMarks(student.getMarks());
		session.getTransaction().commit();
		System.out.println(student.getMarks().size());
		if (session.isOpen())
			session.close();

		return student;
	}

}
