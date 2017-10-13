package Beans;

import Interfaces.AccountantI;
import Interfaces.DBI;
import POJO.Accountant;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class AccountantBean implements AccountantI {
    @EJB
    DBI dbBean;

    public boolean save(Accountant accountant) {
        try {
            String sql = "insert into fee_accountant(name,email,password,address,contact) values(?,?,?,?,?)";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            ps.setString(1, accountant.getName());
            ps.setString(2, accountant.getEmail());
            ps.setString(3, accountant.getPassword());
            ps.setString(4, accountant.getAddress());
            ps.setString(5, accountant.getContact());
            dbBean.dbWrite(ps);

        } catch (Exception ex) {

            System.out.println(ex);
            return false;
        }
        return true;
    }

    public boolean validate(String mail, String pass) {

        String sql = "SELECT * from fee_accountant where email='" + mail + "' and password='" + pass + "'";
        ResultSet rs = dbBean.dbRead(sql);
        try {
            if (rs.next() && rs != null) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
            return false;
        }
        return false;


    }

    public boolean update(Accountant accountant) {
        try {
            String sql = "update fee_accountant set name=?,email=?,password=?,address=?,contact=? where id=?";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            ps.setString(1, accountant.getName());
            ps.setString(2, accountant.getEmail());
            ps.setString(3, accountant.getPassword());
            ps.setString(4, accountant.getAddress());
            ps.setString(5, accountant.getContact());
            ps.setInt(6, accountant.getId());
            dbBean.dbWrite(ps);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

    public int delete(int id) {

        int status = 0;
        try {
            String sql = "delete from fee_accountant where id='" + id + "'";
            PreparedStatement ps = dbBean.createPreparedStatement(sql);
            dbBean.delete(ps);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    public List<Accountant> getAllRecords() {

        List<Accountant> list = new ArrayList<Accountant>();
        try {
            String sql = "select * from fee_accountant";
            ResultSet rs = dbBean.dbRead(sql);
            while (rs.next()) {
                Accountant accountant = new Accountant();
                accountant.setId(rs.getInt(1));
                accountant.setName(rs.getString(2));
                accountant.setEmail(rs.getString(3));
                accountant.setPassword(rs.getString(4));
                accountant.setAddress(rs.getString(5));
                accountant.setContact(rs.getString(6));
                list.add(accountant);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return list;
    }

    public Accountant getRecordById(int id) {
        Accountant accountant = new Accountant();
        try {
            String sql = "select * from fee_accountant where id='" + id + "'";
            ResultSet rs = dbBean.dbRead(sql);
            while (rs.next()) {
                accountant.setId(rs.getInt(1));
                accountant.setName(rs.getString(2));
                accountant.setEmail(rs.getString(3));
                accountant.setPassword(rs.getString(4));
                accountant.setAddress(rs.getString(5));
                accountant.setContact(rs.getString(6));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return accountant;
    }
}
