package com.lm.hib.orm;

/**
 * TaTeacher entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TaTeacher implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer teacherId;
	private String teacherNumber;
	private String teacherName;
	private String teacherSex;
	private Short teacherAge;
	private String del;

	// Constructors

	/** default constructor */
	public TaTeacher() {
	}

	/** full constructor */
	public TaTeacher(String teacherNumber, String teacherName,
			String teacherSex, Short teacherAge, String del) {
		this.teacherNumber = teacherNumber;
		this.teacherName = teacherName;
		this.teacherSex = teacherSex;
		this.teacherAge = teacherAge;
		this.del = del;
	}

	// Property accessors

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherNumber() {
		return this.teacherNumber;
	}

	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSex() {
		return this.teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public Short getTeacherAge() {
		return this.teacherAge;
	}

	public void setTeacherAge(Short teacherAge) {
		this.teacherAge = teacherAge;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}