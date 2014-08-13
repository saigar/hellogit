<%@ page contentType="text/html; charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%
request.setCharacterEncoding("UTF-8");
Context context = new InitialContext();
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Jsp10");
Connection db = ds.getConnection();
PreparedStatement ps = db.prepareStatement("DELETE FROM schedule WHERE sid=?");
ps.setString(1, request.getParameter("sid"));
ps.executeUpdate();
ps.close();
db.close();
response.sendRedirect("select.jsp");
%>
