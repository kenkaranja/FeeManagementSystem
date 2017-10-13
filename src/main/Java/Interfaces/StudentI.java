package Interfaces;

import POJO.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentI {
    boolean save(Student student);

    boolean update(Student student);

    int delete(int rollno);

    int deleteByName(String name);

    List<Student> getAllRecords();

    List<Student> getDues();

    Student getRecordByRollno(int rollno);
}
