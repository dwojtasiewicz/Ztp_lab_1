import model.Rola;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("userName");
        String p = request.getParameter("userPass");


        if (n.equals("admin") && p.equals("admin")) {

            User admin = new User(n, p, Rola.ADMIN);

            request.getServletContext().setAttribute("user", admin);

            RequestDispatcher rd = request.getRequestDispatcher("servletAdmin");

            rd.forward(request, response);
        }
        else
        {
            response.sendRedirect("login.html");
        }


    }
}
