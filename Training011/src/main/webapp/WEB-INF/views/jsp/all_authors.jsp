<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All authors</title>
</head>
<body>
<ol>
<c:forEach var="author" items="${authors}" >
<li><b><c:out value="${author.getLastName().toUpperCase()}"/></b> <c:out value="${author.getFirstName()}"/></li>
</c:forEach>
</ol>

</body>
</html>