package com.zviproject.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "marks", catalog = "Student")
public class Mark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	private Integer id;

	@ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_subject")
	@JsonBackReference
	private Subject subject;

	@Column(name = "mark")
	private Integer mark;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name = "id_student")
	private Student id_student;

	public Student getId_student() {
		return id_student;
	}

	public void setId_student(Student id_student) {
		this.id_student = id_student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Subject getId_subject() {
		return subject;
	}

	public void setId_subject(Subject id_subject) {
		this.subject = id_subject;
	}

}
