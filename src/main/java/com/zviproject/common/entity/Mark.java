package com.zviproject.common.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marks", catalog = "Student")
public class Mark {
	private Integer id;
	private Integer idSubject;
	private Integer idStudent;
	private Integer mark;

	private Student student;

	@ManyToOne // (fetch = FetchType.EAGER, cascade = { CascadeType.MERGE,
				// CascadeType.PERSIST })
	@JoinColumn(name = "id_student", referencedColumnName = "id") // nullable =
	public Student getStudent() {
		return this.student; // false)
	}

	public void setEmployee(Student student) {
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Integer idSubject) {
		this.idSubject = idSubject;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

}
