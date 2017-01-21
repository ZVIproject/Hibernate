package com.zviproject.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.FetchType;
>>>>>>> origin/developer
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
<<<<<<< HEAD
// @Audited
@Table(name = "student", catalog = "Student")
public class Student {
=======
@Table(name = "student", catalog = "Student")
public class Student implements java.io.Serializable {
>>>>>>> origin/developer

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
	@Column(name = "id_student")
=======
	@Column(name = "id_student", nullable = false)
>>>>>>> origin/developer
	private Integer id_student;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "group_id")
	private Integer groupId;

<<<<<<< HEAD
	@OneToMany(mappedBy = "id_student")
	@JsonManagedReference(value = "marks")
	// @NotAudited
=======
	@OneToMany(mappedBy = "id_student", fetch = FetchType.EAGER)
	@JsonManagedReference
>>>>>>> origin/developer
	Set<Mark> marksForStudent = new HashSet<>();

	public Set<Mark> getMarksForStudent() {
		return marksForStudent;
	}

	public void setMarksForStudent(Set<Mark> marksForStudent) {
		this.marksForStudent = marksForStudent;
	}

	public Student() {
	}

<<<<<<< HEAD
	public Student(Integer id_student, String stockCode, String stockName, Integer groupId) {
		this.id_student = id_student;
		this.name = stockCode;
		this.surname = stockName;
		this.groupId = groupId;
=======
	public Student(Integer id_student, String stockCode, String stockName) {
		this.id_student = id_student;
		this.name = stockCode;
		this.surname = stockName;
>>>>>>> origin/developer
	}

	public Integer getId_student() {
		return id_student;
	}

<<<<<<< HEAD
	public void setId_student(Integer id_student) {
		this.id_student = id_student;
=======
	public void setId(Integer id) {
		this.id_student = id;
>>>>>>> origin/developer
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

<<<<<<< HEAD
=======
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

>>>>>>> origin/developer
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}
