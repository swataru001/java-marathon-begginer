<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
税抜き価格
<c:out value="${totalPrice}"/>円<br>
税込み価格
<c:out value="${tatalPriceIncludeTax}"/>円<br>


</body>
</html>