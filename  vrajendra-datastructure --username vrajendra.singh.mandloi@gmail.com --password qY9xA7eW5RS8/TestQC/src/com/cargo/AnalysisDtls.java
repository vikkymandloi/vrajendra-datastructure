package com.cargo;

import java.io.Serializable;

public class AnalysisDtls implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer summaryid;
	private Integer code;
	private String case_element_comment;
	private String case_analysis_comment;
	private String case_investigation_comment;
	private Integer result_cd;
	private Integer pagenumber;
	
	@Override
	public String toString() {
		String str = summaryid+" - "+code+" - "+case_element_comment+" - "+case_analysis_comment+" - "+case_investigation_comment+" - "+result_cd+" - "+pagenumber;
		return str;
	}
	
	public Integer getSummaryid() {
		return summaryid;
	}
	public void setSummaryid(Integer summaryid) {
		this.summaryid = summaryid;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getCase_element_comment() {
		return case_element_comment;
	}
	public void setCase_element_comment(String case_element_comment) {
		this.case_element_comment = case_element_comment;
	}
	public String getCase_analysis_comment() {
		return case_analysis_comment;
	}
	public void setCase_analysis_comment(String case_analysis_comment) {
		this.case_analysis_comment = case_analysis_comment;
	}
	public String getCase_investigation_comment() {
		return case_investigation_comment;
	}
	public void setCase_investigation_comment(String case_investigation_comment) {
		this.case_investigation_comment = case_investigation_comment;
	}
	public Integer getResult_cd() {
		return result_cd;
	}
	public void setResult_cd(Integer result_cd) {
		this.result_cd = result_cd;
	}
	public Integer getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(Integer pagenumber) {
		this.pagenumber = pagenumber;
	}
}
