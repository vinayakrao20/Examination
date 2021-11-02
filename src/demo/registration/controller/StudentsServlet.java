package demo.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.registration.dao.StudentsDao;
import demo.registration.model.Students;

/**
 * Servlet implementation class StudentsServlet
 */
@WebServlet("/register")
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StudentsDao studentsdao=new StudentsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/studentsregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String contact=request.getParameter("contact");
		String username=request.getParameter("username"); 
		String password=request.getParameter("password");
		
		Students students = new Students();
		students.setFirstName(firstName);
		students.setLastName(lastName);
		students.setContact(contact);
		students.setUserName(username);
		students.setPassword(password);
		
	try {
		studentsdao.registerStudent(students);
		
	} 
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/studentdetails.jsp");
	dispatcher.forward(request, response);

		
	}

}
