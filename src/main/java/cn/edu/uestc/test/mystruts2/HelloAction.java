package cn.edu.uestc.test.mystruts2;

/**
 * @author :glb
 * @date :Created in 12:24 2019/6/4
 * @discription :one of service action
 */
public class HelloAction {
    public String helloWorld() {
        System.out.println("invoke success");
        return "success";
    }
}
