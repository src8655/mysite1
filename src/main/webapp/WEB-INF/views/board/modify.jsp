<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="./assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="./board">
				<input type="hidden" name="a" value="modifypost" />
				<input type="hidden" name="no" value="${boardVo.no}" />
				<input type="hidden" name="kwd" value="${kwd_decode}" />
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글수정</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="subject" value="${boardVo.subject}"></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="contents">${boardVo.contents}</textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="./board?a=view&no=${boardVo.no}&kwd=${kwd_encode}">취소</a>
						<input type="submit" value="수정">
					</div>
				</form>				
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>