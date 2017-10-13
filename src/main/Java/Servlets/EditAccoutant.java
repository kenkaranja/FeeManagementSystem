package Servlets;

import Interfaces.AccountantI;
import POJO.Accountant;
import POJO.Student;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "EditAccountant")
public class EditAccoutant extends HttpServlet {
    @Inject
    Accountant accountant;
    @EJB
    AccountantI accountantI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");
        accountant.setContact(contact);
        accountant.setPassword(password);
        accountant.setEmail(email);
        accountant.setAddress(address);
        accountant.setName(name);

        if (accountantI.update(accountant)) {
            resp.sendRedirect("ViewAccountant");
        } else {

        }

    }
}
