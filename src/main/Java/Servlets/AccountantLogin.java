package Servlets;

import Interfaces.AccountantI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "AccountantLogin")
public class AccountantLogin extends HttpServlet {
    @EJB
    AccountantI accountantI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AccountantLoginForm.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String e = req.getParameter("email");
        String p = req.getParameter("password");
        if (accountantI.validate(e, p)) {
            HttpSession session = req.getSession();
            session.setAttribute("accountant", e);
            resp.sendRedirect("accountanthome.jsp");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("AccountantLoginForm.jsp");
            rd.forward(req, resp);
        }
    }
}
