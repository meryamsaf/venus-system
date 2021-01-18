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


import dao.bookingDAO;
import model.Booking;


/**
 * Servlet implementation class viewBookingController
 */
@WebServlet("/viewBookingAdminController")
public class viewBookingAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	* @see HttpServlet#HttpServlet()
	*/
	public viewBookingAdminController() {
		super();
	}
	    /**
	    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	    */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	try {
	    		List<Booking> book = bookingDAO.getAllBooking();
				request.setAttribute("booking", book);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-booking.jsp");
			dispatcher.forward(request, response);
	    }
	}
