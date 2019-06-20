package cn.edu.uestc.test.jdbc;

/**
 * @author :glb
 * @date :Created in 20:13 2019/6/7
 * @discription :the staff of mobile_scm
 */
public class Staff {
    private String id;
    private String name;
    private String age;
    private String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String toString(){
        return "Staff" + "[id=" +getId()+", name=" + getName()+", age="+getAge()+", number="+getNumber()+"]";
    }
}
