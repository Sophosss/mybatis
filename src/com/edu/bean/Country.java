package com.edu.bean;

public class Country {

	/*`c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '国家id',
	 `c_countryname` varchar(128) NOT NULL COMMENT '国家名称',
	 `c_capital` varchar(128) DEFAULT NULL COMMENT '国家首都名称',*/
	private Integer id;
	private String c_countryname;
	private String c_capital;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getC_countryname() {
		return c_countryname;
	}
	public void setC_countryname(String c_countryname) {
		this.c_countryname = c_countryname;
	}
	public String getC_capital() {
		return c_capital;
	}
	public void setC_capital(String c_capital) {
		this.c_capital = c_capital;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", c_countryname=" + c_countryname + ", c_capital=" + c_capital + "]";
	}
	
}
