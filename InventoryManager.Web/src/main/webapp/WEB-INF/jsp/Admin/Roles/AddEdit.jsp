<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label><c:out value="${role.name}"></c:out></label>
	<form:form method="POST" commandname="Role" action="#">  
		<table>  
		<tbody>  
		    <tr>  
		        <td>Name:</td>  
		        <td><form:input path="name" type="text" id="name"></form:input></td>  
		    </tr>  
		    <tr>  
		        <td>Rating:</td>  
		        <td><form:input path="Description"></form:input></td>  
		    </tr>  
		    <tr>  
		        <td><input type="submit" value="Edit"></td>  
		        <td></td>  
		    </tr>  
		</tbody>  
		</table>  
	</form:form>  

</body>
</html>