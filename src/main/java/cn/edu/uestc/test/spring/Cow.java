package cn.edu.uestc.test.spring;

/**
 * @author :glb
 * @date :Created in 18:40 2019/6/5
 * @discription :the implements of animal
 */
public class Cow implements Animal {
    @Override
    public void produce() {
        System.out.println("milk!");
    }
}
