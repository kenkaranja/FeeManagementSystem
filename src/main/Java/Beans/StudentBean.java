package Beans;

import Interfaces.DBI;
import Interfaces.StudentI;
import POJO.Student;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class StudentBean implements StudentI {
    @EJB
    DBI dbBean;

    public boolean save(Student student) {

        try {
            String sql = "insert into fee_student(name,email,sex,course,fee,paid,due,address,contact) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getSex());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getFee());
            ps.setInt(6, student.getPaid());
            ps.setInt(7, student.getDue());
            ps.setString(8, student.getAddress());
            ps.setString(9, student.getContact());
            dbBean.dbWrite(ps);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(Student student) {

        try {

            String sql = "update fee_student set name=?,email=?,sex=?,course=?,fee=?,paid=?,due=?,address=?,contact=? where rollno=?";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getSex());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getFee());
            ps.setInt(6, student.getPaid());
            ps.setInt(7, student.getDue());
            ps.setString(8, student.getAddress());
            ps.setString(9, student.getContact());
            ps.setInt(10, student.getRollno());
            dbBean.dbWrite(ps);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

    public int delete(int rollno) {
        int status = 0;
        try {
            String sql = "delete from fee_student where rollno=?";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            dbBean.delete(ps);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    public int deleteByName(String name) {
        int status = 0;
        try {
            String sql = "delete from fee_student where name=?";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            dbBean.delete(ps);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    public List<Student> getAllRecords() {
        List<Student> list = new ArrayList<Student>();
        try {
            String sql = "select * from fee_student";
            ResultSet rs = dbBean.dbRead(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setSex(rs.getString(4));
                student.setCourse(rs.getString(5));
                student.setFee(rs.getInt(6));
                student.setPaid(rs.getInt(7));
                student.setDue(rs.getInt(8));
                student.setAddress(rs.getString(9));
                student.setContact(rs.getString(10));
                list.add(student);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return list;
    }

    public List<Student> getDues() {
        List<Student> list = new ArrayList<Student>();
        try {
            String sql = "select * from fee_student where due>0";
            ResultSet rs = dbBean.dbRead(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setSex(rs.getString(4));
                student.setCourse(rs.getString(5));
                student.setFee(rs.getInt(6));
                student.setPaid(rs.getInt(7));
                student.setDue(rs.getInt(8));
                student.setAddress(rs.getString(9));
                student.setContact(rs.getString(10));
                list.add(student);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return list;
    }

    public Student getRecordByRollno(int rollno) {
        Student student = new Student();
        try {
            String sql = "select * from fee_student where rollno=?";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            ps.setInt(1, rollno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setSex(rs.getString(4));
                student.setCourse(rs.getString(5));
                student.setFee(rs.getInt(6));
                student.setPaid(rs.getInt(7));
                student.setDue(rs.getInt(8));
                student.setAddress(rs.getString(9));
                student.setContact(rs.getString(10));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return student;
    }
}
