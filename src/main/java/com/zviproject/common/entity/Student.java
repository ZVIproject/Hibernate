package com.zviproject.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student", catalog = "Student")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student", nullable = false)
	private Integer id_student;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "group_id")
	private Integer groupId;

	@OneToMany(mappedBy = "id_student", fetch = FetchType.EAGER)
	@JsonManagedReference
	Set<Mark> marksForStudent = new HashSet<>();

	public Set<Mark> getMarksForStudent() {
		return marksForStudent;
	}

	public void setMarksForStudent(Set<Mark> marksForStudent) {
		this.marksForStudent = marksForStudent;
	}

	public Student() {
	}

	public Student(Integer id_student, String stockCode, String stockName) {
		this.id_student = id_student;
		this.name = stockCode;
		this.surname = stockName;
	}

	public Integer getId_student() {
		return id_student;
	}

	public void setId(Integer id) {
		this.id_student = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}
