package Interfaces;

import POJO.Accountant;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AccountantI {
    boolean save(Accountant accountant);
    boolean validate(String email,String password);
    boolean update(Accountant accountant);
    int delete(int id);
    List<Accountant> getAllRecords();
    Accountant getRecordById(int id);

}
