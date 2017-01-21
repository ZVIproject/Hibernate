package com.zviproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zviproject.Service.GroupService;
import com.zviproject.common.entity.Group;
import com.zviproject.common.entity.Student;

@Configuration
@RestController
@RequestMapping("/zvi/group")
public class GroupController {

	@Autowired
	GroupService groupService;

	/**
	 * Information about all group in DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public List<Group> informationAboutGroup() {
		return groupService.informationAboutGroup();
	}

	/**
	 * Get list with names and surnames all students from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/stud", method = RequestMethod.GET)
	public String listStudent() {
		return "List all students\n" + groupService.listStudent();
	}

	/**
	 * Get all students from one group by group id
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{group}", method = RequestMethod.GET)
	public List<Student> getStudentsByGroup(@PathVariable("group") int group) {
		return groupService.getStudentsByGroup(group);
	}

	/**
	 * Get information about groups with students that have five 
	 * (only names)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/five", method = RequestMethod.GET)
	public List<Group> getGroupWithFive() {
		return groupService.getGroupWithFive();
	}
}
