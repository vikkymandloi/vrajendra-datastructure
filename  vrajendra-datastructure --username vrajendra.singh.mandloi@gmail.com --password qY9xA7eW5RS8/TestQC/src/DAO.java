
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cargo.AnalysisDtls;
import com.cargo.QAeligibility_cargo;

public class DAO{
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	public DAO(){
		try {
			String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(connectionURL, "system",
					"manager");
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int executeQuery(String element_comment,String analysis_comment,String investigation_comment, Integer resultcode, Integer summaryid, Integer code, Integer pagenumber){
		int ret =0;
		try {
			ResultSet rs = stmt.executeQuery("Select count(*) from QA_SNAP_POS_CASE_ANALYSIS_DTLS where QA_SNAP_POS_WS_SUMMARY_ID="+summaryid+" AND CASE_ELEMENT_CD="+code);
			rs.next();
			if(Integer.parseInt(rs.getString(1).toString())!=0){
				pstmt = con.prepareStatement("UPDATE QA_SNAP_POS_CASE_ANALYSIS_DTLS set CASE_ELEMENT_COMMENT=?, CASE_ANALYSIS_COMMENTS=?, CASE_INVESTIGATION_COMMENTS=?, RESULT_CD=? where QA_SNAP_POS_WS_SUMMARY_ID=? AND CASE_ELEMENT_CD=? AND PAGE_NUMBER=?");
			}
			else{
				pstmt = con.prepareStatement("INSERT INTO QA_SNAP_POS_CASE_ANALYSIS_DTLS (CASE_ELEMENT_COMMENT, CASE_ANALYSIS_COMMENTS, CASE_INVESTIGATION_COMMENTS, RESULT_CD, QA_SNAP_POS_WS_SUMMARY_ID, CASE_ELEMENT_CD, PAGE_NUMBER) values (?,?,?,?,?,?,?)");
			}
			pstmt.setString(1, element_comment);
			pstmt.setString(2, analysis_comment);
			pstmt.setString(3, investigation_comment);
			pstmt.setInt(4, resultcode);
			pstmt.setInt(5, summaryid);
			pstmt.setInt(6, code);
			pstmt.setInt(7, pagenumber);
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public List getcodes(int pagenumber){
		List pagecodes = new ArrayList();

		try {
			ResultSet rs = stmt.executeQuery("Select CODE from RT_QAELIGIBILITYANDPAYDETER_MV where PAGE_NUMBER="+pagenumber);
			// take all the values from RT_QAELIGIBILITYANDPAYDETER_MV table and put them into a list
			while(rs.next()){
				pagecodes.add(rs.getInt("CODE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagecodes;
	}

	public List searchList(){
		List listQAeligibilitycargo = new ArrayList();

		try {
			ResultSet rs = stmt.executeQuery("Select * from RT_QAELIGIBILITYANDPAYDETER_MV");
			// take all the values from RT_QAELIGIBILITYANDPAYDETER_MV table and put them into a list
			while(rs.next()){
				QAeligibility_cargo elig_cargo = new QAeligibility_cargo();
				elig_cargo.setCode(rs.getInt("CODE"));
				elig_cargo.setDescription(rs.getString("DESCRIPTION"));
				elig_cargo.setElement_ctg(rs.getString("ELEMENT_CTG"));
				elig_cargo.setElement_ctg_cd(rs.getInt("ELEMENT_CTG_CD"));
				elig_cargo.setElement_sub_ctg(rs.getString("ELEMENT_SUB_CTG"));
				elig_cargo.setPagenumber(rs.getInt("PAGE_NUMBER"));
				//System.out.println(elig_cargo.toString());
				listQAeligibilitycargo.add(elig_cargo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listQAeligibilitycargo;
	}

	public Map searchMap(int pagenumber, int summaryid){
		Map analys_dtls = new HashMap();
		try {

			ResultSet rs = stmt.executeQuery("Select * from QA_SNAP_POS_CASE_ANALYSIS_DTLS where QA_SNAP_POS_WS_SUMMARY_ID="+summaryid+" AND PAGE_NUMBER="+pagenumber);

			while(rs.next()){
				AnalysisDtls analysiscargo = new AnalysisDtls();
				int code = rs.getInt("CASE_ELEMENT_CD");
				analysiscargo.setCode(code);
				analysiscargo.setCase_analysis_comment(rs.getString("CASE_ANALYSIS_COMMENTS"));
				analysiscargo.setCase_element_comment(rs.getString("CASE_ELEMENT_COMMENT"));
				analysiscargo.setResult_cd(rs.getInt("RESULT_CD"));
				analysiscargo.setCase_investigation_comment(rs.getString("CASE_INVESTIGATION_COMMENTS"));
				analysiscargo.setSummaryid(rs.getInt("QA_SNAP_POS_WS_SUMMARY_ID"));
				analysiscargo.setPagenumber(rs.getInt("PAGE_NUMBER"));
				//System.out.println(analysiscargo.toString());
				analys_dtls.put(code, analysiscargo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return analys_dtls;
	}

	public Map searchSummary(Integer summaryid){
		Map summary_map = new HashMap();
		try {
			ResultSet rs = stmt.executeQuery("Select * from QA_SNAP_POS_WS_SUMMARY where QA_SNAP_POS_WS_SUMMARY_ID="+summaryid);
			rs.next();

			summary_map.put("casename", rs.getString(2));
			summary_map.put("casenumber", rs.getInt(3));
			summary_map.put("reviewnumber", rs.getInt(4));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return summary_map;
	}
}
