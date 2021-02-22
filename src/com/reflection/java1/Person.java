package reflection.java1;

/**
 * @author 阿昌
 * @create 2020-10-14 22:38
 */
@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;
    private static int money = 100;

    public Person() {
    }

    @MyAnnotation("abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是: " + nation);
        return nation;
    }

    public String display(String interests, int age) throws RuntimeException, NullPointerException {
        return interests + age;
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void play() {
        System.out.println("我是一个爱玩的人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

}
