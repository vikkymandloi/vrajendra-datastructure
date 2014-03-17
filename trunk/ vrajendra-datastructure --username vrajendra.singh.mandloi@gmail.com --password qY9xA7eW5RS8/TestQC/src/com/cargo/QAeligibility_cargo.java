package com.cargo;

import java.io.Serializable;

public class QAeligibility_cargo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String description;
	private String element_sub_ctg;
	private String element_ctg;
	private Integer element_ctg_cd;
	private Integer pagenumber;
	
	@Override
	public String toString() {
		String str = code+" - "+description+" - "+element_sub_ctg+" - "+element_ctg+" - "+element_ctg_cd+" - "+pagenumber;
		return str;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getElement_sub_ctg() {
		return element_sub_ctg;
	}
	public void setElement_sub_ctg(String element_sub_ctg) {
		this.element_sub_ctg = element_sub_ctg;
	}
	public String getElement_ctg() {
		return element_ctg;
	}
	public void setElement_ctg(String element_ctg) {
		this.element_ctg = element_ctg;
	}
	public Integer getElement_ctg_cd() {
		return element_ctg_cd;
	}
	public void setElement_ctg_cd(Integer element_ctg_cd) {
		this.element_ctg_cd = element_ctg_cd;
	}
	public Integer getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(Integer pagenumber) {
		this.pagenumber = pagenumber;
	}
	
}
