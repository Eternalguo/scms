package cn.edu.uestc.test.spring;

/**
 * @author :glb
 * @date :Created in 18:44 2019/6/5
 * @discription :the production  of animal
 */
public class Prodution {
    private Animal animal;
    public Prodution() {

    }
    public Prodution(Animal animal) {
        this.animal = animal;
    }
    public void produce() {
        animal.produce();
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
