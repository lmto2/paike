package com.lm.hib.orm;

/**
 * TaRoomType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TaRoomType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5424910898316956330L;
	private Integer typeId;
	private String typeName;
	private String userfor;

	// Constructors

	/** default constructor */
	public TaRoomType() {
	}

	/** full constructor */
	public TaRoomType(String typeName, String userfor) {
		this.typeName = typeName;
		this.userfor = userfor;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUserfor() {
		return this.userfor;
	}

	public void setUserfor(String userfor) {
		this.userfor = userfor;
	}

}