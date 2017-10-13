package Servlets;

import Interfaces.StudentI;
import POJO.Student;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditStudent extends HttpServlet {
    @EJB
    StudentI studentI;
    @Inject
    Student student;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rollno = Integer.parseInt(req.getParameter("rollno"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String course = req.getParameter("course");
        int fee = Integer.parseInt(req.getParameter("fee"));
        int paid = Integer.parseInt(req.getParameter("paid"));
        int due = Integer.parseInt(req.getParameter("due"));
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");

        student.setPaid(paid);
        student.setSex(sex);
        student.setFee(fee);
        student.setEmail(email);
        student.setDue(due);
        student.setCourse(course);
        student.setRollno(rollno);
        student.setName(name);
        student.setAddress(address);
        student.setContact(contact);


        if (studentI.update(student)) {
            resp.sendRedirect("ViewStudent");
        }

    }
}
