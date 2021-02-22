package reflection.java;

/**
 * @author 阿昌
 * @create 2020-10-13 20:05
 */
public class Person {

    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println("你好,我是你爸爸");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是:" + nation);
        return nation;
    }

}
