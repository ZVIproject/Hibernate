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

	@Column(name = "id_subject")
	private Integer id_subject;

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

	public Integer getid_subject() {
		return id_subject;
	}

	public void setid_subject(Integer id_subject) {
		this.id_subject = id_subject;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

}
