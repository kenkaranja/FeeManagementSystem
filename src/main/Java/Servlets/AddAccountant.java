package Servlets;

import Interfaces.AccountantI;
import POJO.Accountant;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "AddAccountant")
public class AddAccountant extends HttpServlet {
    @EJB
    AccountantI accountantI;
    @Inject
    Accountant accountant;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddAccountantForm.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");
        accountant.setName(name);
        accountant.setAddress(address);
        accountant.setEmail(email);
        accountant.setPassword(password);
        accountant.setContact(contact);
        if (accountantI.save(accountant)) {
            out.println("Accountant is added successfully!");
            req.getRequestDispatcher("AddAccountantForm.jsp").forward(req, resp);
        }
    }
}
