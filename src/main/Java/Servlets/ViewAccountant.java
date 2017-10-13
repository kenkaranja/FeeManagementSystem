package Servlets;

import Interfaces.AccountantI;
import POJO.Accountant;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "ViewAccountant")
public class ViewAccountant extends HttpServlet {
    @EJB
    AccountantI accountantI;
    @Inject
    Accountant accountant;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Accountant> accountantList =accountantI.getAllRecords();
        req.setAttribute("alist",accountantList);
    }
}
