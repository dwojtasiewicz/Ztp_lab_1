import model.Rola;
import model.User;

import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "UserServlet", urlPatterns = "/servletUser")
public class UserServlet extends HttpServlet {

    HashMap<String,String> userSource = new HashMap<>();

    public void init()
    {

        userSource.put("user1","user1");
        userSource.put("user2","user2");
        userSource.put("user3","user3");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("userName");
        String p=request.getParameter("userPass");

        if(checkUser(n,p)){
            ServletContext context = request.getServletContext();
            context.setAttribute("user",new User(n,p,Rola.USER));

            RequestDispatcher rd=request.getRequestDispatcher("servletDashboard");
            rd.forward(request,response);
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("loginFailed.html");
            rd.include(request,response);
        }
    }
    private boolean checkUser(String name,String password)
    {
        if (userSource.containsKey(name))
        {
            String storedPassword = userSource.get(name);
            if (storedPassword.equals(password))
            {
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }


}
