package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ApplyDao;
import model.Apply;


/**
 * Servlet implementation class Application
 */
@WebServlet("/register")
public class Application extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Application() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String course=request.getParameter("course");
		String email=request.getParameter("email");
		long phnumber= Long.parseLong(request.getParameter("phnumber"));
		int age= Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");

		Apply apply=new Apply();
		apply.setFirstname(firstname);
		apply.setLastname(lastname);
		apply.setEmail(email);
		apply.setCourse(course);
		apply.setPhnumber(phnumber);
		apply.setAge(age);
		apply.setGender(gender);
	
		ApplyDao applydao=new ApplyDao();
		
		try {
			applydao.insertApplication(apply);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/ApplyView.jsp");
			rd.forward(request,response);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
