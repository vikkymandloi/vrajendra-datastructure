<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="ex" uri="WEB-INF/timestampcustomtld.tld"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ex:timestamptag /> 
	<form action="submitbean" method="post">
		
		Username : <input id="username" name="username" type="text" value="Vrajendra Singh Mandloi"/>
		Password : <input id="password" name="password" type="password" value="vikkymandloi"/>
		Number : <input id="number" name="number" type="text" value="967"/>
		
		<input type="submit" />
	</form>
</body>
</html>