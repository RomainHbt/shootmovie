package fr.iutinfo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Moderation
 */
@WebServlet("/moderation")
public class Moderation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userdao = App.dbi.open(UserDao.class);
	private static VideoDao vdao = App.dbi.open(VideoDao.class);

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterator<User> usersIterator = userdao.selectLastUsers();
		String users = "";
		
		while(usersIterator.hasNext()){
			User u = usersIterator.next();
			users += u.getId()+":"+u.getPseudo()+":"+u.getEmail()+":"+u.getType()+":"+u.getDateInscription();
			users += "|";
		}
		
		Iterator<Video> videosIterator = vdao.getLastVideo();
		String videos = "";
		while(videosIterator.hasNext()){
			Video v = videosIterator.next();
			videos += v.getId()+ "§" +v.getTitre() + "§" + v.getRealisateur() + "§" + v.getDateUpload();
			videos += "£";
		}
		
		request.setAttribute("videos", videos);
		request.setAttribute("users", users);
		this.getServletContext().getRequestDispatcher("/moderator.jsp").forward(request, response);
	}

}
