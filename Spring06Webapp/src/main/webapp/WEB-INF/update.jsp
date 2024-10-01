<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ページの言語をJavaに設定し、エンコードをUTF-8に設定 -->

<%@page import="uetak.Entity.Shain"%>
<!-- Shainクラスをインポート。Shainは社員情報を持つクラス -->

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>社員更新画面</title>
<!-- ページタイトルを「社員更新画面」に設定 -->

<style>
/* フォーム全体の幅を100%にする */
.form-input {
	width: 100%;
}

/* テーブルのセルにパディングを追加 */
.form-table td {
	padding: 5px;
}

/* ラベルのテキストを右揃えにする */
.form-table label {
	text-align: right;
}

/* ボタンにマージンを追加 */
.form-button {
	margin-top: 10px;
}
</style>
</head>

<body>
	<!-- リクエストスコープからShainオブジェクトを取得 -->
	<%
	Shain shain = (Shain) request.getAttribute("shain");
	%>

	<h1>社員更新画面</h1>
	<!-- ページの見出しとして「社員更新画面」を表示 -->

	<!-- 社員情報を更新するためのフォーム -->
	<form action="update" method="post">
		<!-- POSTメソッドでデータを`/update`に送信 -->
		<table class="form-table">
			<!-- フォームの各フィールドをテーブル形式で表示 -->

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
				<td><label for="gender">性別:</label></td>
				<td><%=shain.getGender()%></td>
				<!-- 社員の性別を表示 -->
			</tr>

			<tr>
				<td><label for="nen">年:</label></td>
				<td><%=shain.getNen()%></td>
				<!-- 社員の年を表示 -->
			</tr>

			<tr>
				<td><label for="address">住所:</label></td>
				<td>
					<!-- 社員の住所を表示し、編集可能なテキストフィールド --> <input type="text" id="address"
					name="address" value="<%=shain.getAddress()%>" class="form-input"
					required>
				</td>
			</tr>
		</table>

		<!-- フォームの送信ボタン。データを送信して更新する -->
		<button type="submit" class="form-button">更新</button>

		<!-- 隠しフィールドで他の社員情報も送信 -->
		<input type="hidden" name="id" value="<%=shain.getId()%>"> <input
			type="hidden" name="name" value="<%=shain.getName()%>"> <input
			type="hidden" name="gender" value="<%=shain.getGender()%>"> <input
			type="hidden" name="nen" value="<%=shain.getNen()%>">
	</form>
</body>

</html>
