package cn.edu.uestc.dao;

import java.sql.SQLException;

public interface CommonDAO {
    public Object queryObject(String sqlID, Object parameter) throws SQLException;
}
