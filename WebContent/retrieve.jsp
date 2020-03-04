<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기</title>
<script type="text/javascript">
	function pwdUrl(mode) {
		document.frm.action = "pwdCheckui.do";
		document.frm.method = "post";
		document.frm.mode.value = mode;
		document.frm.submit();
	}
</script>
</head>
<body>
	<h1>글 자세히 보기</h1>
	<form name="frm">
		<input type="hidden" name="num" value="${retrieve.num }"> <input
			type="hidden" name="mode">
	</form>
	<table border="1" width="600">
		<colgroup>
			<col width="150"></col>
			<col width="150"></col>
			<col width="150"></col>
			<col width="150"></col>
		</colgroup>
		<tr>
			<td>글번호</td>
			<td>${retrieve.num }<span>(조회수:${retrieve.readcnt })</span></td>
			<td>작성일</td>
			<td>${retrieve.writeday }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${retrieve.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td colspan="3">${retrieve.author }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3">${retrieve.content }</td>
		</tr>
	</table>
	<div>
		<a href="list.do">[글목록]</a>&nbsp;&nbsp; <a
			href="javascript:pwdUrl('update')">[글수정]</a> <a
			href="javascript:pwdUrl('delete')">[글삭제]</a> <a
			href="replyui.do?num=${retrieve.num }">[답변달기]</a>
	</div>
</body>
</html>