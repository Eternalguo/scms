package cn.edu.uestc.dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.sql.SQLException;

/**
 * @author :glb
 * @date :Created in 21:56 2019/6/11
 * @discription :the implement of common DAO
 */
public class CommonDAOImpl extends SqlMapClientTemplate implements CommonDAO {
    public Object queryObject(String sqlID, Object parameter) throws SQLException {
       return getSqlMapClient().queryForObject(sqlID, parameter);
    }
}
