package com.zviproject.common.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zviproject.common.entity.Group;
import com.zviproject.common.entity.Student;
import com.zviproject.common.interfacee.IGroup;
import com.zviproject.common.persistence.HibernateUtil;

@Repository
public class GroupDao implements IGroup {

	/**
	 * Information about all group
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Group> informationAboutGroup() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		final String hql = "SELECT g FROM Group g";
		Query query = session.createQuery(hql);

		ArrayList<Group> groups = (ArrayList<Group>) query.list();
		return groups;

	}

	@Override
	public Group informationAboutGroupById() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Group.class);

		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String listStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		final String hql = "select cast(group_concat(s.name, ' ', s.surname, ' ') as char)  as list from student as s";
		Query query = session.createSQLQuery(hql);
		String fullNames = (String) query.uniqueResult();

		return fullNames;
	}

	/**
	 * Get all students from one group by group id
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Student> getStudentsByGroup(int group) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Student.class)
				// .createAlias("marksForStudent", "marks")
				.add(Restrictions.eq("groupId", group));

		List<Student> students = (List<Student>) criteria.list();

		return students;
	}

	/**
	 * Get information about groups with students that have five
	 * 
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Group> getGroupWithFive(DetachedCriteria detachedCriteria) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Group> groups = (List<Group>) detachedCriteria.getExecutableCriteria(session).list();

		return groups;
	}

}
