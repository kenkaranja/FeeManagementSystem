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

@WebServlet(urlPatterns = "ViewStudent")
public class ViewStudent extends HttpServlet {
    @EJB
    StudentI studentI;
    @Inject
    Student student;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentI.getAllRecords();
        req.setAttribute("sList", studentList);
    }
}
