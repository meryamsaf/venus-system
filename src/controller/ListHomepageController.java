package controller;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.HomepageDAO;

@WebServlet("/ListHomepageController")
public class ListHomepageController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HomepageDAO dao;
    
    public ListHomepageController() {
        super();
        dao = new HomepageDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vID = Integer.parseInt(request.getParameter("vID"));//No Function
        
        request.setAttribute("homepage", HomepageDAO.getAllHomepage());
        RequestDispatcher view = request.getRequestDispatcher("view-homepage.jsp");
        view.forward(request, response);
    }
}