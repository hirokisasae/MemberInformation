package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.MembersDAO;
import jp.co.aforce.bean.Members;
import jp.co.aforce.tool.Page;

public class Change extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);

		try {
			String keyword = request.getParameter("keyword");

			MembersDAO dao = new MembersDAO();
			List<Members> list = dao.search(keyword);

			for (Members m : list) {
				out.println(m.getMember_no());
				out.println(m.getName());
				out.println(m.getAge());
				out.println(m.getBirth_year());
				out.println(m.getBirth_month());
				out.println(m.getBirth_day());
			}

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
