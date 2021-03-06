package com.zviproject.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
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
	@Transactional(rollbackFor = Exception.class)
	public void add(Student student) {
		Session session = null;
		Student student1 = new Student();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.save(student);

		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	/**
	 * Information about all student
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Student> informationAboutStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		final String hql = "SELECT s FROM Student s";
		Query query = session.createQuery(hql);
		ArrayList<Student> student = (ArrayList<Student>) query.list();

		return student;
	}

	/**
	 * Remove student by id
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void removeById(int id_student) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Student studnetDelete = (Student) session.get(Student.class, id_student);
			session.delete(studnetDelete);

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Update student by id
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateStudentById(Integer id, Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student studentUpdate = (Student) session.get(Student.class, id);
		studentUpdate.setName("JHGD");
		studentUpdate.setSurname("jvchd");
		studentUpdate.setGroupId(3);

	}

	/**
	 * Search student by id
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Student searchById(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Student student = (Student) session.get(Student.class, id);
			return student;
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * Information about marks by id
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Set<Mark> getAllMarks(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = (Student) session.get(Student.class, id);

		return student.getMarksForStudent();

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void test() {

	}

	/**
	 * Get all students by mark
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Student> getStudentMarks(int mark) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Student.class, "name").createAlias("marksForStudent", "marks").addOrder(Order.desc("name")).setProjection(Projections.groupProperty("name")).add(Restrictions.eq("marks.mark", mark));
		List<Student> students = (List<Student>) criteria.list();
		return students;
	}

}
