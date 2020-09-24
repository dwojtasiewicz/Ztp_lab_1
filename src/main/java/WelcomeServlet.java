import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       User login =null;
       login = (User) request.getServletContext().getAttribute("user");

        if(login!=null){
            RequestDispatcher rd=request.getRequestDispatcher("/servletDashboard");
            rd.forward(request, response);

        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
    }

}
