package com.lm.hib.orm;

/**
 * TaTrainPro entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TaTrainPro implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer trainProId;
	private String trainProName;
	private String studyTerm;
	private String trainProPresent;
	private Integer majorId;

	// Constructors

	/** default constructor */
	public TaTrainPro() {
	}

	/** full constructor */
	public TaTrainPro(String trainProName, String studyTerm,
			String trainProPresent, Integer majorId) {
		this.trainProName = trainProName;
		this.studyTerm = studyTerm;
		this.trainProPresent = trainProPresent;
		this.majorId = majorId;
	}

	// Property accessors

	public Integer getTrainProId() {
		return this.trainProId;
	}

	public void setTrainProId(Integer trainProId) {
		this.trainProId = trainProId;
	}

	public String getTrainProName() {
		return this.trainProName;
	}

	public void setTrainProName(String trainProName) {
		this.trainProName = trainProName;
	}

	public String getStudyTerm() {
		return this.studyTerm;
	}

	public void setStudyTerm(String studyTerm) {
		this.studyTerm = studyTerm;
	}

	public String getTrainProPresent() {
		return this.trainProPresent;
	}

	public void setTrainProPresent(String trainProPresent) {
		this.trainProPresent = trainProPresent;
	}

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

}