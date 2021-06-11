package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.MembersDAO;
import jp.co.aforce.bean.Members;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/jsp/registration" })
public class Registration extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yymmddhhmmss");

		try {
			String member_no = format.format(date);
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			int birth_year = Integer.parseInt(request.getParameter("birth_year"));
			int birth_month = Integer.parseInt(request.getParameter("birth_month"));
			int birth_day = Integer.parseInt(request.getParameter("birth_day"));

			Members m = new Members();
			m.setMember_no("A" + member_no);
			m.setName(name);
			m.setAge(age);
			m.setBirth_year(birth_year);
			m.setBirth_month(birth_month);
			m.setBirth_day(birth_day);

			MembersDAO dao = new MembersDAO();
			int line = dao.insert(m);

			if (line > 0) {
				out.println("登録に成功しました。");
			} else {
				out.println("登録に失敗しました。");
			}

		} catch (

		Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
