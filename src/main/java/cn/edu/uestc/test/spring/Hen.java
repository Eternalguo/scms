package cn.edu.uestc.test.spring;

/**
 * @author :glb
 * @date :Created in 18:42 2019/6/5
 * @discription :the implements of Animal
 */
public class Hen implements Animal {
    @Override
    public void produce() {
        System.out.println("egg!");
    }
}
