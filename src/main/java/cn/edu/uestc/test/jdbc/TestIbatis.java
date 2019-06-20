package cn.edu.uestc.test.jdbc;

import java.io.FileInputStream;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


/**
 * @author :glb
 * @date :Created in 12:25 2019/6/10
 * @discription :test the mybatis demo
 */
public class TestIbatis {
    public static void main(String[] args) throws Exception {
        String path = TestIbatis.class.getClassLoader().getResource("").getPath();
        String file = path + "ibatis.xml";
        SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(new FileInputStream(file));
        Staff staff = (Staff)client.queryForObject("fandstaff", 1);
        System.out.println(staff);
    }
}
