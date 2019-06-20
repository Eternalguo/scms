package cn.edu.uestc.test.mystruts2;

import cn.edu.uestc.test.service.TestService;

import java.sql.SQLException;

/**
 * @author :glb
 * @date :Created in 15:26 2019/6/4
 * @discription :the test action of service
 */
public class TestAction {

    private String name;
    private TestService testService;
    public void setTestService(TestService testService) {
        this.testService = testService;
    }



    public String execute(){
        System.out.println(name);
        try {
            name = testService.validateName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ret";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
