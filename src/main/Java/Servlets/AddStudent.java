package Servlets;

import Beans.StudentBean;
import Interfaces.StudentI;
import POJO.Student;

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

@WebServlet(urlPatterns = "AddStudent")
public class AddStudent extends HttpServlet {
    @EJB
    StudentI studentI;
    @Inject
    Student student;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddStudentForm.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String course = req.getParameter("course");
        int fee = Integer.parseInt(req.getParameter("fee"));
        int paid = Integer.parseInt(req.getParameter("paid"));
        int due = Integer.parseInt(req.getParameter("due"));
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");

        student.setAddress(address);
        student.setContact(contact);
        student.setCourse(course);
        student.setDue(due);
        student.setEmail(email);
        student.setFee(fee);
        student.setSex(sex);
        student.setPaid(paid);

        if (studentI.save(student)) {
            out.println("Student is added successfully!");
            resp.sendRedirect("AddStudentForm.jsp");

        } else {
            out.println("Sorry! Something went wrong, Repeat");
            RequestDispatcher rd = req.getRequestDispatcher("AddStudentForm.jsp");
            rd.forward(req, resp);
        }

    }
}
