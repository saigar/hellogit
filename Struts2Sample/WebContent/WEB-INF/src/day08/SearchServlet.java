package day08;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		response.setContentType("text/html;charset=Windows-31J");
		PrintWriter out = response.getWriter();
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat tformat = new SimpleDateFormat("HH時mm分");
		out.println("<html><head>");
		out.println("<title>簡易スケジュール帳</title>");
		out.println("</head><body>");
		out.println("<h1 style='background:#cccccc'>簡易スケジュール帳</h1>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>日付</th><th>時刻</th><th>予定名</th><th>備考</th><th>削除</th>");
		out.println("</tr>");
		ArrayList<Schedule> list = Schedule.getInfos();
		for(Schedule info : list){
			out.println("<tr>");
			out.println("<td>" + info.getSdate() + "</td>");
			out.println("<td>" + info.getStime() + "</td>");
			out.println("<td>" + info.getTitle() + "</td>");
			out.println("<td>" + info.getMemo() + "</td>");
			out.println("<td><input type=\"button\" value=\"削除\"" +
				"onclick=\"location.href='delete.jsp?sid=" + info.getSid() + "'\" /></td>");			
			out.println("</tr>");
		}
		out.println("</table></body></html>");
	}
}
