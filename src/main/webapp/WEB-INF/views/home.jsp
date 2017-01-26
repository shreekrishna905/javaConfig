<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<c:if test="${ not empty users }">
	<table>
	<thead>
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th> Email </th>
	</tr>
	
	</thead>
	<tbody>
			
				<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
				</tr>
				</c:forEach>
	
	</tbody>
	
	</table>
	
	
	
	</c:if>


</body>
</html>
