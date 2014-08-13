<%@ page contentType="text/html; charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*" %>
<%
Context context = new InitialContext();
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Jsp10");
Connection db = ds.getConnection();
PreparedStatement ps = db.prepareStatement("SELECT * FROM schedule ORDER BY sdate, stime");
ResultSet rs = ps.executeQuery();
SimpleDateFormat dformat = new SimpleDateFormat("yyyy年MM月dd日");
SimpleDateFormat tformat = new SimpleDateFormat("HH時mm分");
%>

<html>
<head>
<title>書籍管理アプリ（表示・削除）</title>
</head>
<body>
<h1 style="background:#cccccc">書籍管理アプリ（表示・削除）</h1>
<table border="1">
<tr>
	<th>日付</th><th>時刻</th><th>予定名</th><th>備考</th><th>削除</th><th>編集</th>
</tr>
<% while(rs.next()){ %>
	<tr>
		<td><%=dformat.format(rs.getDate("sdate")) %></td>
		<td><%=tformat.format(rs.getTime("stime")) %></td>
		<td><%=rs.getString("title") %></td>
		<td><%=rs.getString("memo") %></td>
		<td>
			<input type="button" value="削除"
				onclick="location.href='delete.jsp?sid=<%=rs.getString("sid") %>'" />
		</td>
				<td>
			<input type="button" value="編集"
				onclick="location.href='edit.jsp?sid=<%=rs.getString("sid") %>'" />
		</td>
	</tr>
<%
}
rs.close();
ps.close();
db.close();
%>
</table>
</body>
</html>
