<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<div id="header">
			<h1>MySite</h1>
			<ul>
			<c:if test="${authUser eq null}">
				<li><a href="./user?a=loginform">로그인</a><li>
				<li><a href="./user?a=joinform">회원가입</a><li>
			</c:if>
			<c:if test="${authUser ne null}">
				<li><a href="./user?a=updateform">회원정보수정</a><li>
				<li><a href="./user?a=logout">로그아웃</a><li>
				<li>${authUser.name}님 안녕하세요 ^^;</li>
			</c:if>
			</ul>
		</div>