<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Servlet Web Page</title>
</head>
<body>
	<h3>Hello, you sent: <b><%= request.getAttribute("text") %></b></h3>
</body>
</html>