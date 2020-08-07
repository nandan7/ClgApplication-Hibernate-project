package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/SignupView.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email"); //get email from jsp page
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDao userdao=new UserDao();
		try {
			int checkUser=userdao.signup(user);
			if(checkUser!=0) {
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				request.setAttribute("message","Registration Successful");
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/SignupView.jsp");
				rd.forward(request,response);
			  }
			else {
				request.setAttribute("message","Check your credentials");
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/SignupView.jsp");
				rd.forward(request,response);
			}
		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}


}
