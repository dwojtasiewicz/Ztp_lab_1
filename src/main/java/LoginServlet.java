import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name=request.getParameter("userName");

        if(name.equals("admin")){
            RequestDispatcher rd=request.getRequestDispatcher("AdminLoginServlet");
            rd.forward(request, response);

        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("servletUser");
            rd.include(request, response);
        }

    }

}
