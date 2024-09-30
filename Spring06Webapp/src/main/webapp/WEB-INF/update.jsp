<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ページの基本設定 -->
<%@page import="uetak.Entity.Shain"%>
<!-- Shainクラスをインポート -->

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>社員更新画面</title>
<!-- ページタイトルを「社員更新画面」に設定 -->
<style>
/* フォームのスタイル設定 */
.form-input {
	width: 100%;
}

.form-table td {
	padding: 5px;
}

.form-table label {
	text-align: right;
}

.form-button {
	margin-top: 10px;
}
</style>
</head>

<body>
	<!-- shainから社員情報を取得する -->
	<%
	Shain shain = (Shain) request.getAttribute("shain");
	%>
	<!-- リクエストスコープからShainオブジェクトを取得 -->

	<h1>社員更新画面</h1>
	<!-- ページの見出しとして「社員更新画面」を表示 -->

	<form action="update" method="post">
	<!-- POSTメソッドで`update`エンドポイントにデータを送信するフォーム -->
		<table class="form-table">
			<tr>
				<td><label for="id">ID:</label></td>
				<td><%=shain.getId()%></td>
				<!-- 社員IDを表示 -->
			</tr>
			<tr>
				<td><label for="name">名前:</label></td>
				<td><%=shain.getName()%></td>
				<!-- 社員の名前を表示 -->
			</tr>
			<tr>
				<td><label for="sei">性別:</label></td>
				<td><%=shain.getGender()%></td>
				<!-- 社員の性別を表示 -->
			</tr>
			<tr>
				<td><label for="nen">年:</label></td>
				<td><%=shain.getNen()%></td>
				<!-- 社員の入社年を表示 -->
			</tr>
			<tr>
				<td><label for="address">住所:</label></td>
				<td><%=shain.getAddress() %></td>
				<!-- 社員の住所を表示 -->
			</tr>
		</table>
		<!-- 社員情報を表形式で表示 -->

		<button type="submit" class="form-button">更新</button>
		<!-- 更新ボタンを表示 -->
	</form>
</body>

</html>
