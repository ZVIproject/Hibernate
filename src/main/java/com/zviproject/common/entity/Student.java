package com.zviproject.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Audited
@Table(name = "student", catalog = "Student")
public class Student {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student")
	private Integer id_student;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "group_id")
	private Integer groupId;

	@OneToMany(mappedBy = "id_student")
	@JsonManagedReference(value = "marks")
	@NotAudited
	Set<Mark> marksForStudent = new HashSet<>();

	public Set<Mark> getMarksForStudent() {
		return marksForStudent;
	}

	public void setMarksForStudent(Set<Mark> marksForStudent) {
		this.marksForStudent = marksForStudent;
	}

	public Student() {
	}

	public Student(Integer id_student, String stockCode, String stockName, Integer groupId) {
		this.id_student = id_student;
		this.name = stockCode;
		this.surname = stockName;
		this.groupId = groupId;
	}

	public Integer getId_student() {
		return id_student;
	}

	public void setId_student(Integer id_student) {
		this.id_student = id_student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}
