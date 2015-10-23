<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>..::PERICO'S INVENTORY MANAGER - ADMIN ROLES</title>
</head>
<body>
<h3>Persons List</h3>
	<c:if test="${!empty roles}">
	    <table class="tg">
	    <tr>
	        <th width="80">ID</th>
	        <th width="120">Name</th>
	        <th width="120">Description</th>
			<th width="60">Edit</th>
        	<th width="60">Delete</th>        
	    </tr>
	    <c:forEach items="${roles}" var="role">
	        <tr>
	            <td><c:out value="${role.id}"></c:out></td>
	            <td><c:out value="${role.name}"></c:out></td>
	            <td><c:out value="${role.description}"></c:out></td>	
	            <td><a href="<c:url value='/Admin/roles/edit/${role.id}' />" >Edit</a></td>
            	<td><a href="<c:url value='/Admin/roles/remove/${role.id}' />" >Delete</a></td>            
	        </tr>
	    </c:forEach>
	    </table>
	</c:if>
</body>
</html>