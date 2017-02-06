package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;

/**
 * Servlet implementation class StudentManager
 */
@WebServlet("/StudentManager")
public class StudentManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		showAllStudent(response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

	/**
	 * get allstudent in db
	 * @throws IOException 
	 */
	protected void showAllStudent(HttpServletResponse response) throws IOException {
		List<Student> lst_student = new Student().getAllStudent();
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>List students</title>");
			out.println("<link href=\"Style/stylesheet.css\" rel=\"stylesheet\" />");
			out.println("</head");
			out.println("<body>");
			out.println("<center>");
			out.println("<div>");
			out.println("<h1>Thông tin sinh viên</h1>");
			out.println("<div class=\"divTable\">");
			out.println("<div class=\"divTableBody\">");
			//table title
			out.println("<div class=\"divTableRow divTableHeader\">");
			out.println("<div class=\"divTableCell\">ID</div>");
			out.println("<div class=\"divTableCell\">Name</div>");
			out.println("<div class=\"divTableCell\">Code</div>");
			out.println("<div class=\"divTableCell\">Average score</div>");
			out.println("<div class=\"divTableCell\">Birth day</div>");
			out.println("<div class=\"divTableCell\">Address</div>");
			out.println("</div>");
			
			for(Student st : lst_student){
				out.println("<div class=\"divTableRow\">");
				out.println("<div class=\"divTableCell\">"+st.getStudent_id()+"</div>");
				out.println("<div class=\"divTableCell textleft\">"+st.getStudent_name()+"</div>");
				out.println("<div class=\"divTableCell\">"+st.getStudent_code()+"</div>");
				out.println("<div class=\"divTableCell\">"+st.getAverage_score()+"</div>");
				out.println("<div class=\"divTableCell\">"+st.getDate_of_birth()+"</div>");
				out.println("<div class=\"divTableCell textleft\">"+st.getAddress()+"</div>");
				out.println("</div>");
			}
			out.println("</div>");
			out.println("</div>");
			out.println("<h3>Tổng số sinh viên: "+lst_student.size()+"</h3>");
			out.println("</div>");
			out.println("</center>");
			out.println("</body>");
			
		}
	}

}
