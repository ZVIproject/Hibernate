package com.zviproject.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zviproject.common.entity.Mark;
import com.zviproject.common.entity.Student;
import com.zviproject.common.interfacee.IStudent;
import com.zviproject.common.persistence.HibernateUtil;

@Repository
public class StudentDao implements IStudent {

	/**
	 * Propagation -
	 * 
	 * Required - якщо транзакція виконувалася раніше, то вона буде продовжена
	 * інакше почата нова, якщо вона почата, то повинна бути закрита.
	 * 
	 * Mandatory - визивається в області раніше початої транзакції, якщо
	 * визваний поза транзакцією буде створене виключення "
	 * TransactionRequiredException "
	 * 
	 * RequiresNew - створює нову транзакцію, якщо була перед цим транзакція він
	 * її прериває і створює нову яка повинна бути закрита, після чого
	 * продовжена попередня транзакція.
	 * 
	 * Supports - виконується у поточній транзакції, за її межами не працює.
	 * 
	 * NotSupported - означає, що метод не повинен виконуватися під час другої
	 * транзакції, якщо визвати підчас транзакції, то транзакція буде зупинена
	 * до моменту завершення " NoSupported ".
	 * 
	 * Never - працює як NotSupported, але не може працювати за межами
	 * транзакції, створюючи виключення, використовується в ТЕСТУВАННІ.
	 * 
	 *
	 * rollbackFor - для забезпечення правильної поведінки в обробці
	 * контролюючих виключень.
	 * 
	 * noRollbackFor - вказує, що будь-яке виключення крім заданих, повинне
	 * призводити до відкату транзакції.
	 */

	/**
	 * Add student to DB
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void add(Student student) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.save(student);
		} catch (Exception e) {
			// Транзакція буде зупинена
			throw e;
		}

	}

	/**
	 * Information about all student
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Student> informationAboutStudent() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// session.beginTransaction();
			final String hql = "SELECT s FROM Student s";
			Query query = session.createQuery(hql);
			ArrayList<Student> student = (ArrayList<Student>) query.list();
			// session.getTransaction().commit();

			return student;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Remove student by id
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void removeById(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Student studnetDelete = (Student) session.get(Student.class, id);
			session.delete(studnetDelete);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Update student by id
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateStudentById(Integer id, Student student) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Student studentUpdate = (Student) session.get(Student.class, id);
			studentUpdate.setName(student.getName());
			studentUpdate.setSurname(student.getSurname());
			session.update(studentUpdate);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Search student by id
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Student searchById(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Student student = (Student) session.get(Student.class, id);

			session.getTransaction().commit();
			return student;
		} catch (Exception e) {

			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Set<Mark> getAllMarks(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Student student = (Student) session.get(Student.class, id);
			session.getTransaction().commit();
			return student.getMarksForStudent();

		} catch (Exception e) {

			throw e;
		}
	}

}
