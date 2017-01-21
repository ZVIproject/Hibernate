package com.zviproject.Service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zviproject.common.entity.Group;
import com.zviproject.common.entity.Student;
import com.zviproject.common.interfacee.IGroup;

@Service
public class GroupService {

	@Autowired
	@Qualifier("groupDao")
	private IGroup iGroup;

	public List<Group> informationAboutGroup() {
		return iGroup.informationAboutGroup();
	}

	public String listStudent() {
		return iGroup.listStudent();
	}

	public List<Student> getStudentsByGroup(int group) {
		return iGroup.getStudentsByGroup(group);
	}

	/**
	 * Get information about groups with students that have five
	 * 
	 * @return
	 */
	public List<Group> getGroupWithFive() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Group.class)
				.addOrder(Order.asc("title"))
				.createAlias("student", "students")
				.setProjection(Projections.groupProperty("title"))
				.createAlias("students.marksForStudent", "marks")
				.add(Restrictions.eq("marks.mark", 5));
		return iGroup.getGroupWithFive(detachedCriteria);
	}
}
