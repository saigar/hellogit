<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*" %>
<%
/* Context context = new InitialContext();
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Jsp10");
PreparedStatement ps = db.prepareStatement("UPDATE schedule set WHERE sid=?");
ps.setString(1, request.getParameter("sid"));
ps.executeUpdate();

SimpleDateFormat dformat = new SimpleDateFormat("yyyy年MM月dd日");
SimpleDateFormat tformat = new SimpleDateFormat("HH時mm分"); */
%>
<html>
<head>
<title>書籍管理アプリ（編集）</title>
</head>
<body>
<h1 style="background:#cccccc">書籍管理アプリ（編集）</h1>
<form method="POST" action="EditServlet">
<table border="0">
	<tr>
		<th align="right">予定名：</th>
		<td><input type="text" name="title" size="50" maxlength="255" /></td>
	</tr>
	<tr>
		<th align="right">日付：</th>
		<td>
			<input type="text" name="sdate_year" size="4" maxlength="4" />年
			<input type="text" name="sdate_month" size="2" maxlength="2" />月
			<input type="text" name="sdate_day" size="2" maxlength="2" />日
		</td>
	</tr>
	<tr>
		<th align="right">開始時間：</th>
		<td>
			<input type="text" name="stime_hour" size="2" maxlength="2" />時
			<input type="text" name="stime_minute" size="2" maxlength="2" />分
		</td>
	</tr>
	<tr>
		<th align="right">備考：</th>
		<td><input type="text" name="memo" size="70" maxlength="255" /></td>
	</tr>
	<tr>
		<td rowspan="2">
			<input type="submit" value="更新" />
			<input type="reset" value="クリア" />
			<input type="hidden"name="sid" value=<%=request.getParameter("sid") %> />
		</td>
	</tr>
</table>
</form>
</body>
</html>
