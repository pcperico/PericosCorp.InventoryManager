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
	<c:url var="processAction" value="/Admin/roles/process" ></c:url>
	<form:form action="/Admin/roles/process" modelAttribute="role"  enctype="multipart/form-data" method="POST">
		 <form:label path="name">
                <spring:message text="Name: "/>
         </form:label>
		<form:input path="name" />
		<br />
		<form:label path="description">
                <spring:message text="Description: "/>
         </form:label>
		<form:input path="description" />
		<br />
		<c:if test="${role.id>0}">
                <input type="submit" value="<spring:message text="Edit Role"/>" />
        </c:if>
        <c:if test="${role.id == 0}">
        	<input type="submit" value="<spring:message text="Add Role"/>" />
        </c:if>
	</form:form>

</body>
</html>