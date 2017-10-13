package Interfaces;

import javax.ejb.Local;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Local
public interface DBI {
    void connect();

    void closeResource();

    PreparedStatement createPreparedStatement(String s);

    boolean dbWrite(PreparedStatement preparedStatement);

    ResultSet dbRead(String s);

    int delete(PreparedStatement ps);


}
