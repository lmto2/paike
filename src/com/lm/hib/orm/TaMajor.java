package com.lm.hib.orm;

/**
 * TaMajor entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TaMajor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer majorId;
	private String majorNumber;
	private String majorName;
	private String majorPresent;
	private String del;

	// Constructors

	/** default constructor */
	public TaMajor() {
	}

	/** full constructor */
	public TaMajor(String majorNumber, String majorName, String majorPresent,
			String del) {
		this.majorNumber = majorNumber;
		this.majorName = majorName;
		this.majorPresent = majorPresent;
		this.del = del;
	}

	// Property accessors

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getMajorNumber() {
		return this.majorNumber;
	}

	public void setMajorNumber(String majorNumber) {
		this.majorNumber = majorNumber;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorPresent() {
		return this.majorPresent;
	}

	public void setMajorPresent(String majorPresent) {
		this.majorPresent = majorPresent;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}