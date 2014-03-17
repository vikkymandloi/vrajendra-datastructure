<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function submitform(){
	var firstpage = document.getElementById('FirstPage');
	firstpage.action = "InstantiateModule";
	firstpage.submit();
}

</script>
</head>
<body>
<form name="FirstPage" id="FirstPage" method="post">
	<input type="submit" id="nextpage" value="next" onclick="submitform()"/>
</form>

</body>
</html>