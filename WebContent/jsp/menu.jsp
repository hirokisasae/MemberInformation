<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="Stylesheet" href="css/registration.css">
<%@include file="../header.html"%>

<div>
	<form>
		<h4>メニュー画面</h4>

		<h4>
			<input type="button" value="会員情報新規登録" class="button2" 
			onClick="document.location='../jsp/registration.jsp';">
		</h4>

		<h4>
			<input type="button" value="会員情報変更" class="button2"
			onClick="document.location='../jsp/change.jsp';">
		</h4>

		<h4>
			<input type="button" value="会員情報削除" class="button2" 
			onClick="document.location='../jsp/delete.jsp';">
		</h4>
	</form>
</div>

<%@include file="../footer.html"%>