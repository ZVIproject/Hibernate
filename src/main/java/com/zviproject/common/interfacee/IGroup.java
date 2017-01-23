package com.zviproject.common.interfacee;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zviproject.common.entity.Group;
import com.zviproject.common.entity.Student;

public interface IGroup {
	public List<Group> informationAboutGroup();

	public Group informationAboutGroupById();

	public String listStudent();

	public List<Student> getStudentsByGroup(int group);

	public List<Group> getGroupWithFive(DetachedCriteria detachedCriteria);

}
