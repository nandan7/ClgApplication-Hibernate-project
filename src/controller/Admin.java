package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplyDao;
import model.Apply;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email"); 
		String password=request.getParameter("password");
		String email1="nandan.98@gmail.com";
		String password1="nandan";
		if(email.matches(email1) && password.matches(password1)) {

			
            ApplyDao applydao=new ApplyDao();
            List<Apply> listview=null;
            try {
            	
				listview=applydao.displayAll();
				for(Apply applylist: listview) {
					request.setAttribute("firstname",applylist.getFirstname());
					System.out.println(applylist.getFirstname());
					request.setAttribute("lastname",applylist.getLastname());
					request.setAttribute("course",applylist.getCourse());
					request.setAttribute("email",applylist.getEmail());
					request.setAttribute("phnumber",applylist.getPhnumber());
					request.setAttribute("age",applylist.getAge());
					request.setAttribute("gender",applylist.getGender());
				
				}
				
				request.setAttribute("listview", listview);
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView.jsp");
				rd.forward(request,response);
			} 
            catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
				
		}
		else {

			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin.jsp");
			rd.forward(request,response);
		}
	}

}
