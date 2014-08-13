package day08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Schedule info = new Schedule();
		info.setTitle(request.getParameter("title"));
		info.setSdate(request.getParameter("sdate_year") + "-" +
			request.getParameter("sdate_month") + "-" +
			request.getParameter("sdate_day"));
		info.setStime(request.getParameter("stime_hour") + ":" +
				request.getParameter("stime_minute"));
		info.setMemo(request.getParameter("memo"));
		info.setSid(Integer.parseInt(request.getParameter("sid")));
		String a=request.getParameter("sid");
		info.editInfo();
		response.sendRedirect("select.jsp");
	}
}
