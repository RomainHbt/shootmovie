package fr.iutinfo;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class Signup extends HttpServlet{
	private static UserDao userdao = App.dbi.open(UserDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		userdao.createTable();
		String pseudo = req.getParameter("login");
		String password = req.getParameter("mdp");
		String user = userdao.selectPseudo(pseudo);
		Calendar cal = Calendar.getInstance();
		String day;
		String month;
		String year = "" + cal.get(Calendar.YEAR);
		if(cal.get(Calendar.DAY_OF_MONTH) < 10)
			day = 0 + "" + cal.get(Calendar.DAY_OF_MONTH);
		else
			day = cal.get(Calendar.DAY_OF_MONTH) + "";
		if(cal.get(Calendar.MONTH)+1 < 10)
			month = 0 + "" + (cal.get(Calendar.MONTH) + 1);
		else
			month = cal.get(Calendar.MONTH) + "";
		String date = day+"/"+month+"/"+year;
		if(user == null){
			userdao.insertUser(pseudo, password, date);
			res.sendRedirect("login.jsp?inscription");
		}
		else
			res.sendRedirect("inscription.html");
	}
}
