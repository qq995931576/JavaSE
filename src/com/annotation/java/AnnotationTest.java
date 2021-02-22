package annotation.java;

import java.util.ArrayList;

/**
 * 注解的使用:
 * 1. 理解Annotation:
 * ① jdk5.0 新增功能
 * ② Annotation其实就是代码的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。
 * 通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。
 * ③ 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，
 * 例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 * <p>
 * 2. Annotation的使用示例
 * 示例一: 生成文档相关的注解
 * 示例二: 在编译时进行格式检查(JDK内置的三个基本注解)
 *
 * @author 阿昌
 * @Override: 限定重写父类方法，该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器报错
 * 实例三: 跟踪代码依赖性，实习替代配置文件功能
 * <p>
 * 3. 如何自定义注解: 参照@SuppressWarnings定义
 * ① 注解声明为: @interface
 * ② 内部定义成员，通常使用value表示
 * ③ 可以指定成员的默认值，使用default定义
 * ④ 如果自定义注解没有成员，表明是一个标识作用
 * <p>
 * 如果注解有成员，在使用注解时，需要指明成员的值。
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 * 自定义注解通常都会指明两个元注解: Retention、Target
 * <p>
 * 4. jdk提供的4种元注解
 * 元注解: 对现有的注解进行解释说明的注解
 * Retention: 指定所修饰的 Annotation 的生命周期: SOURCE/CLASS(默认行为)/RUNTIME
 * 只有声明为RUNTIME声明周期的注解，才能通过反射获取。
 * Target: 用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 * <p>
 * ----↓出现的频率较低------
 * Documented: 表示所修饰的注解在被javadoc解析式，保存下来。 (默认情况下:javadoc解析不保留注解)
 * Inherited: 被修饰的 Annotation 将具有继承性。
 * <p>
 * 5. 通过反射来获取注解信息 ---> 到反射系统讲解
 * <p>
 * 6. jdk8.0 注解新特性:
 * ① 可重复注解
 * 1) 在MyAnnotation上声明@Repeatable,成员值为MyAnnotations.class
 * 2) MyAnnotation的@Target，@Retention等元注解与MyAnnotations相同
 * ② 类型注解
 * 1) ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语 句中（如：泛型声明）。
 * 2) ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中
 * @create 2020-10-11 19:44
 */
public class AnnotationTest {

}


//jdk 8 之前的写法:
//@MyAnnotations({@MyAnnotation("Hello"),@MyAnnotation("hi")})

//jdk 8 新特性 :可重复性注解
@MyAnnotation("Hello")
@MyAnnotation("hi")
class Person {
    private String name;
    private Integer age;

    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("走路");
    }

    public void eat() {
        System.out.println("吃饭");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }

    @Override
    public void show() {

    }
}

//在@MyAnnotation中的元注解@Target加入ElementType.TYPE_PARAMETER，此注解就可以修饰泛型(可通过反射获取)
class Generic<@MyAnnotation T> {

    //在@MyAnnotation中的元注解@Target加入TYPE_USE，就可以修饰任何语句(可通过反射获取)
    public void show() throws @MyAnnotation RuntimeException {

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;

    }

}