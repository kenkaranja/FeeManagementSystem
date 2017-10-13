package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "AdminLogin")
public class LoginAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AdminLoginForm.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email.equals("admin@gmail.com") && password.equals("admin123")) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", "true");
            req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
        } else {
            out.println("<p>Sorry, username or password error!</p>");
            req.getRequestDispatcher("AdminLoginForm.jsp").forward(req, resp);
        }
    }
}
