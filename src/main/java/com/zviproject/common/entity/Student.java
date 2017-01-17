package com.zviproject.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "student", catalog = "Student")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String surname;
	private Integer groupId;

	private Set<Mark> marks = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student", fetch = FetchType.EAGER)
	public Set<Mark> getMarks() {
		return marks;
	}

	public void addMarks(Mark mark) {
		mark.setEmployee(this);
		this.marks.add(mark);
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public Student() {
	}

	public Student(Integer id, String stockCode, String stockName) {
		this.id = id;
		this.name = stockCode;
		this.surname = stockName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
