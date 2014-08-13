<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%!
private String createOption(int start, int end){
	StringBuffer builder = new StringBuffer();
	for(int i=start;i<=end;i++){
		builder.append("<option value='" + i + "'>" + i + "</option>");
	}
	return builder.toString();
}
%>
<html>
<head>
<title>書籍管理アプリ（登録）</title>
</head>
<body>
<h1 style="background:#cccccc">書籍管理アプリ（登録）</h1>
<s:form action="InsertServlet!doPost.action">
	<table border="0">
		<tr>
			<th align="right">予定名：</th>
			<td><input type="text" name="title" size="50" maxlength="255" /></td>
		</tr>
		<tr>
			<th align="right">日付：</th>
			<td>
				<select name="sdate_year"><%=createOption(2008, 2015)%></select>年
				<select name="sdate_month"><%=createOption(1, 12)%></select>月
				<select name="sdate_day"><%=createOption(1, 31)%></select>日
			</td>
		</tr>
		<tr>
			<th align="right">開始時間：</th>
			<td>
				<select name="stime_hour"><%=createOption(0, 23)%></select>時
				<select name="stime_minute"><%=createOption(0, 59)%></select>分
			</td>
		</tr>
		<tr>
			<th align="right">備考：</th>
			<td><input type="text" name="memo" size="70" maxlength="255" /></td>
		</tr>
		<tr>
			<td rowspan="2">
				<s:submit value="登録" />
				<input type="reset" value="クリア" />
			</td>
		</tr>
	</table>

	</s:form>
</body>
</html>
