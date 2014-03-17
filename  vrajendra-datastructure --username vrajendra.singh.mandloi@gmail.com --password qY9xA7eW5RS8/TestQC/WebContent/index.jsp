<%@page import="com.cargo.AnalysisDtls"%>
<%@page import="com.cargo.QAeligibility_cargo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
textarea{
width: 470px; 
height: 78px; 
max-width: 470px; 
min-width: 470px; 
max-height: 78px; 
min-height: 78px; 
background-color: #99FFFF;
}
table{
border-style: double none solid none;
}
td{
border-style: none solid none none;
}
</style>
<script type="text/javascript">
	function submitform(btnvalue) {
		var firstpage = document.getElementById('Indexpage');
		if (btnvalue == "Previous")
			firstpage.action = "RequestHandler?navto=Previous";
		if (btnvalue == "Next")
			firstpage.action = "RequestHandler?navto=Next";
		firstpage.submit();
	}
</script>

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<!-- Upper table for case details -->
	<center>
		<table>
			<tr>
				<td>Case Number : <%=session.getAttribute("casenumber")%></td>
				<td>Case Name : <%=session.getAttribute("casename")%></td>
			</tr>
			<tr>
				<td>Review Num : <%=session.getAttribute("reviewnumber")%></td>
				<td>Summary ID : <%=session.getAttribute("summaryid")%></td>
			</tr>
		</table>
	</center>

	<%
		List qalist = (ArrayList) session
				.getAttribute("listQAeligibilitycargo");
		Map analysisdata = (HashMap) request.getAttribute("analys_dtls");
	%>

	<!-- data manipulation -->
	<center>
		<form id="Indexpage" name="Indexpage" method="post">
			<table>
				<tr style="font-size: 16px" >
					<th width="30%">ELEMENTS OF ELIGIBILITY AND BASIS OF ISSUANCE</th>
					<th width="30%">QC ANALYSIS OF CASE RECORD (Pertinent facts,
						sources of verification, reliability, gaps or deficiencies)</th>
					<th width="30%">FINDINGS OF FIELD INVESTIGATION (Facts
						obtained, verification and substantiation, nature of errors)</th>
					<th width="10%">RESULTS</th>
				</tr>
				<%
					for (int i = 0; i < qalist.size(); i++) {
						QAeligibility_cargo qacargo = (QAeligibility_cargo) qalist
								.get(i);
						int pagenumber = qacargo.getPagenumber();
						if (Integer.parseInt(session.getValue("pagenumber").toString()) == pagenumber) {
							int code = qacargo.getCode();
							AnalysisDtls adl = new AnalysisDtls();
							adl = (AnalysisDtls) analysisdata.get(code);
							String element_comment = "";
							String analysis_comment = "";
							String investigation_comment = "";

							if (adl != null) {
								element_comment = adl.getCase_element_comment() != null ? adl
										.getCase_element_comment() : "";
								analysis_comment = adl.getCase_analysis_comment() != null ? adl
										.getCase_analysis_comment() : "";
								investigation_comment = adl
										.getCase_investigation_comment() != null ? adl
										.getCase_investigation_comment() : "";
							} else {
								element_comment = "";
								analysis_comment = "";
								investigation_comment = "";
							}
							Integer result_opt = Integer.parseInt(adl.getResult_cd().toString());
							// header section no duplicates
							String ele_hdr = qacargo.getElement_ctg().toString()+" - "+qacargo.getElement_ctg_cd().toString();
							
				%>
				<tr align="left" style="font-size: 12px">
					<td width="30%"><%=qacargo.getCode().toString() + " "
							+ qacargo.getDescription().toString()%></td>
					<td width="30%" colspan="2" align="center"><%=ele_hdr%></td>
					<td width="10%"></td>
				</tr>
				<!-- style="width: 470px; height: 78px; max-width: 470px; min-width: 470px; max-height: 78px; min-height: 78px; background-color: 99FFFF" -->
				<tr align="left" style="font-size: 18px" height="80px">
					<td width="30%"><textarea id="<%=code%>_element_comment"
							name="<%=code%>_element_comment"><%=element_comment%></textarea></td>
					<td width="30%"><textarea id="<%=code%>_analysis_comment"
							name="<%=code%>_analysis_comment"><%=analysis_comment%></textarea></td>
					<td width="30%"><textarea id="<%=code%>_investigation_comment"
							name="<%=code%>_investigation_comment"><%=investigation_comment%></textarea></td>
					<td width="10%"><select id="<%=code%>_result_opt"
						name="<%=code%>_result_opt" > <% if(result_opt==1 || result_opt== 0){ %>
							<option value="1" selected="selected">No Error</option>
							<option value="2">Agency Error</option>
							<option value="3">Client Error</option><% }  if(result_opt==2) { %>
							<option value="2" selected="selected">Agency Error</option>
							<option value="1">No Error</option>
							<option value="3">Client Error</option><% }  if(result_opt==3) { %>
							<option value="3" selected="selected">Client Error</option>
							<option value="1">No Error</option>
							<option value="2">Agency Error</option><% } %>
					</select></td>
				</tr>
				<%
						}
					}
				%>
			</table>
		</form>
		<input type="submit" name="PREVIOUS" id="PREVIOUS" value="Previous"
			onclick="submitform(PREVIOUS.value)" /> <input type="submit"
			name="NEXT" id="NEXT" value="Next" onclick="submitform(NEXT.value)" />

		<!-- 
		<input type="submit" name="PREVIOUS" id="PREVIOUS" value="Previous"
			onclick="location.href='/TestQC/RequestHandler?navto=Previous'" /> <input
			type="submit" name="NEXT" id="NEXT" value="Next"
			onclick="location.href='/TestQC/RequestHandler?navto=Next'" />  -->
	</center>
</body>
</html>