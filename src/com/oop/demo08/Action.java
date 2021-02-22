package com.oop.demo08;

//abstract 抽象类: 类 extends：只能单继承     （接口可以多继承）
public abstract class Action {

    //约束 有人帮我们实现
    //abstract 抽象方法,只有方法名字，没有方法的实现
    public abstract void doSomething();

    public Action() {
        //无参构造器
    }

    public Action(int a) {
        //有参构造
    }

    //1. 不能直接创建抽象类的实例对象，也就是不能new这个抽象类，只能靠它的子类去实现它 ；约束
    //2. 抽象类里面可以写普通方法
    //3. 抽象方法必须是在抽象类中
    //抽象的抽象：约束

    //思考题
    //抽象类存在构造器吗？      ---存在，可以有有参构造和无参构造
    //抽象类存在的意义是什么？   ---防止重复代码，提高开发效率。后期通过子类拓展，提高后期可拓展性
}
