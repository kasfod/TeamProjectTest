<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output Form</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<table border="1" align="center"></table>

	<thead>
		<tr>
			<th colspan="4">Member List</th>
		</tr>
	</thead>

	<tbody>
		<tr>
			<th>Seq</th>
			<th>writer</th>
			<th>message</th>
			<th>write_date</th>
		</tr>

		<c:choose>
			<c:when test="${GameUserDTO.size() != 0 }">
				<c:forEach var="i" items="${list }">
					<tr>
						<td>${i.seq }</td>
						<td>${i.writer }</td>
						<td>${i.message }</td>
						<td>${i.write_date }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td>Messages가 비어있습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan=3 align=center><a href='/index.jsp'>back</a>
		</tr>
	</tbody>

</body>
</html>