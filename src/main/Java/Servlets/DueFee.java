package Servlets;

import Interfaces.StudentI;
import POJO.Student;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "DueFee")
public class DueFee extends HttpServlet {
    @Inject
    Student student;
    @EJB
    StudentI studentI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentI.getDues();
        req.setAttribute("dlist", studentList);
    }
}
