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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "SearchStudent")
public class SearchStudent extends HttpServlet {
    @EJB
    StudentI studentI;
    @Inject
    Student student;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String srollno = req.getParameter("rollno");
        int rollno = Integer.parseInt(srollno);
        student.setRollno(rollno);
        studentI.getRecordByRollno(rollno);
        if (student.getRollno() > 0) {
            out.println("<table class='table table-bordered table-striped'>");
            out.print("<tr><td>Rollno:</td><td>" + student.getRollno() + "</td></tr>");
            out.print("<tr><td>Name:</td><td>" + student.getName() + "</td></tr>");
            out.print("<tr><td>Email:</td><td>" + student.getEmail() + "</td></tr>");
            out.print("<tr><td>Sex:</td><td>" + student.getSex() + "</td></tr>");
            out.print("<tr><td>Course:</td><td>" + student.getCourse() + "</td></tr>");
            out.print("<tr><td>Fee:</td><td>" + student.getFee() + "</td></tr>");
            out.print("</table>");
        } else {
            out.println("<p>Sorry, No Record found for " + rollno + "</p>");
        }
    }
}
