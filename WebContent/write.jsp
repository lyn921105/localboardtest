<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>게시판 글쓰기 화면</h1>
	<form action="write.do" method="post">
		<table border="1" width="600" align="center">
			<colgroup>
				<col width="250"></col>
				<col width="350"></col>
			</colgroup>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" cols="80" rows="5"></textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd"></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="저장"/>
			<input type="button" value="목록보기" onclick="location.href='list.do'"/>
		</div>
	</form>
</body>
</html>