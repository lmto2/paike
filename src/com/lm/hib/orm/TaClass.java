package com.lm.hib.orm;

/**
 * TaClass entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TaClass implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer classId;
	private String classNumber;
	private String className;
	private Integer majorId;
	private String del;
	
	private String majorName;
	// Constructors

	/** default constructor */
	public TaClass() {
	}

	/** full constructor */
	public TaClass(String className, Integer majorId, String del,
			String classNumber) {
		this.className = className;
		this.majorId = majorId;
		this.del = del;
		this.classNumber = classNumber;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

}