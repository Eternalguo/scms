package cn.edu.uestc.test.service;

import cn.edu.uestc.dao.CommonDAO;

import java.sql.SQLException;

/**
 * @author :glb
 * @date :Created in 19:55 2019/6/5
 * @discription :test the service
 */
public class TestService {
    private CommonDAO dao;
    public String validateName(String name) throws SQLException {
        int count = (Integer) dao.queryObject("staff.findname", name);
        if (count > 0) {
            return "welcome " + name + "!";
        }else{
            return "valid name " + name + "!";
        }
    }

    public void setDao(CommonDAO dao) {
        this.dao = dao;
    }
}
