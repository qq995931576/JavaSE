package com.oop.demo02;

import com.oop.demo10.Outer;

public class Application {

    public static void main(String[] args) {
        Outer outer = new Outer();

    }
}

























/*
public class Application {
    public static void main(String[] args) {
        //类型之间的转换: 父  子

        //高                     低
        Person acc = new Student();

        // acc 将这个对象转换为Student类型，我们就可以使用Student类的方法

        ((Student)acc).go();//将Person类acc强制装换为Student类acc，这样才能调用Student类下的方法go();

        //子类 转 父类 可能会丢失一些自己本来的一些方法
        Student student = new Student();
        student.go();
        Person person = student;

    }
}


1. 父类 引用指向 子类 对象
2.把子类转换为父类，向上转转型； 可以直接转换过去 不需要强制转换 可能会用不了子类本身的方法 会丢失方法
3.把父类转换为子类，向下转转型； 需要强制转换，会丢失精度，丢失掉子类独有的方法
4.方便方法的调用，减少重复的代码，有效提升利用率，简洁

抽象： 封装、继承、多态
 */









/*public class Application {
    public static void main(String[] args) {

        //一个对象的实际类型是确定的
        //new Student();
        //new Person();

        //可以指向的引用类型就不确定了:父类的引用指向子类

        //Student 能调用的方法都是自己的 或者是 继承父类的所有方法
        Student s1 = new Student();
        //Person是父类型 虽然可以指向子类，但是不能调用子类独有的方法
        Person s2 = new Student();
        Object s3 = new Student();

        //对象能执行哪些方法，主要看对象左边的类型，和右边关系不大
        s2.run();//son  子类重写了，父类的方法，执行子类的方法
        s1.run();//son
    }
}

多态注意事项：
1.多态是方法的多态，属性没有多态
2.父类和子类，需要有联系，继承关系 不然会类型转换异常！ClassCastException(类型转换异常）
3.多态存在的条件：继承关系、方法需要重写，父类引用指向子类对象 father f1 = new son();

不能被重写的
1.static方法 属于类，它不属于任何一个实例
2.final 常量
3.private方法 私有的，不能被重写
 */






















/*
public class Application {
    public static void main(String[] args) {
        /*
        1. 类与对象
            类是一个模版，对象是一个具体的实例
            类是 抽象的，对象是 具体的
        2. 方法
            定义、调用！
        3. 对象的引用
            引用类型： 基本类型（8大基本类型）
            对象是通过引用来操作的： 栈--->堆（指向堆中的一个地址）

        4. 对象的属性：字段Field  成员变量
            默认初始化：
                数字： 0   0.0
                char： u0000
                boolean： false
                引用类型： null

            修饰符   属性类型 属性名 = 属性值

        5. 对象的创建和使用
            - 必须使用 new 关键字创造对象，且有构造器 Person achang = new Person();
            - 对象的属性 achang.name;
            - 对象的方法 acang.sleep();

        6. 类：
            静态的属性   属性
            动态的行为   方法

        ·封装、继承、多态·
*/



/*
封装的意义
1. 提高程序的安全性，保护数据
2. 隐藏代码的实现细节
3. 统一接口
4. 提高系统的可维护性

public class Application {
    public static void main(String[] args) {
        Teacher s1 = new Teacher();

        s1.setName("阿昌");
        System.out.println(s1.getName());

        s1.setAge(66);
        System.out.println(s1.getAge());

    }
}
*/
















/*
        //类：抽象的，需要实例化
        //类实例化后会返回一个自己的对象！
        //xiaoming、xiaohong对象就是一个Student类的具体实例！

        Student xiaoming = new Student();
        Student xh = new Student();

        xiaoming.name = "小明";
        xiaoming.age = 3;

        System.out.println(xiaoming.name);
        System.out.println(xiaoming.age);

        xh.name = "小红";
        xh.age = 3;
        System.out.println(xh.name);
        System.out.println(xh.age);

 */

/*
    public static void main(String[] args) {
        //new 实例化了一个对象
        Person person = new Person("阿昌",21); //它会自动判断调用无参还是有参构造

        System.out.println(person.name);//阿昌
        System.out.println(person.age);

    }
 */

/*
public class Application {
    public static void main(String[] args) {

        Pet dog = new Pet();
        dog.name ="旺财";
        dog.age  = 3;
        dog.shout();

        System.out.println(dog.name);
        System.out.println(dog.age);

        Pet cat = new Pet();

    }
}
 */