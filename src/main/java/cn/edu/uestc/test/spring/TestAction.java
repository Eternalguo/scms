package cn.edu.uestc.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :glb
 * @date :Created in 18:42 2019/6/5
 * @discription :test the action of one of animal
 */
public class TestAction {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Prodution prodution = (Prodution) applicationContext.getBean("production");
        prodution.produce();
    }
}
