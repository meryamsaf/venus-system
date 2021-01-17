package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServiceDAO;
import model.Service;

/**
 * Servlet implementation class ListServiceController
 */
@WebServlet("/ListServiceController")
public class ListServiceController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Service> service = ServiceDAO.getServiceList();
		request.setAttribute("service", service);
		
		//redirect to diff page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("listService.jsp");
		dispatcher.forward(request,  response);
		
	}

	

}
