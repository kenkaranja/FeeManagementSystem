package Servlets;

import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "DeleteStudent")
public class DeleteStudent extends HttpServlet {
    @EJB
    StudentI studentI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String srollno = req.getParameter("rollno");
        int rollno = Integer.parseInt(srollno);
        studentI.delete(rollno);
        resp.sendRedirect("ViewStudent");
    }
}
