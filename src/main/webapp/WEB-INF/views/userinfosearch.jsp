<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="userForm" action="${pageContext.request.contextPath}/seach/create">
ID検索<form:input path="id"/><br>
<input type="submit" value="検索">
</form:form>
</body>
</html>