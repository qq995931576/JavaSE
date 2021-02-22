package reflection.java2;

import org.junit.Test;
import reflection.java1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中的指定的结构: 属性、方法、构造器
 *
 * @author 阿昌
 * @create 2020-10-16 18:40
 */
public class ReflectionTest {

    //调用运行时类中的属性  --  不需要掌握
    //权限太低,只能获取public修饰
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性: 要求运行时类中属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        设置当前属性的值
        set(): 参数1: 指明设置哪个对象的属性
               参数2: 将此属性设置为多少
         */
        id.set(p, 1001);

        /*
        获取当前属性的值
        get(): 参数1: 获取哪个对象的当前属性值
         */
        int pid = (int) id.get(p);
        System.out.println(pid);

    }

    /*
    如何操作运行时类中的指定属性  --  需要掌握
     */
    @Test
    public void testField1() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1. getDeclaredField(String fieldName): 获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2. 保证当前属性可访问的
        name.setAccessible(true);

        //3. 获取、设置指定对象的此属性值
        name.set(p, "PePe");
        String pname = (String) name.get(p);

        System.out.println(pname);

        /*
        如何调用静态属性
        静态方法由类来调用
         */
        // private static void play()

        Field money = clazz.getDeclaredField("money");
        money.setAccessible(true);
        money.set(Person.class, 999);
        System.out.println(money.get(p));

    }


    /*
    如何操作运行时类的指定方法  --  需要掌握
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        /*1. 获取指定的某个方法
        getDeclaredMethod(): 参数1: 指明要获取方法名的名称
                             参数2: 指明要获取方法的形参列表 (重载的方法可能有很多，需要提供此方法的参数类型)
        */
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2. 保证当前方法是可访问的
        show.setAccessible(true);

        /*3. 调用方法的invoke()去执行
        invoke(): 参数1: 指明方法的调用者
                  参数2: 指明给方法形参复制的实参
        invoke()的返回值即为对应类中调用方法的返回值。
         */
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("===================");

        /*
        如何调用静态方法
        静态方法由类来调用
         */
        // private static void play()

        Method play = clazz.getDeclaredMethod("play");
        play.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
//        Object returnValue1 = play.invoke(null);
        Object returnValue1 = play.invoke(Person.class);
        System.out.println(returnValue1);//null

    }

    /*
    如何调用运行时类的指定构造器
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;

        //private Person(String name)
        /*1. 获取指定构造器:
          getDeclaredConstructor(): 参数: 指明构造器的参数列表(变量的类型)
        */
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        //2. 保证此构造器可访问
        declaredConstructor.setAccessible(true);

        //3. 调用此构造器创建运行时类的对象
        Person per = (Person) declaredConstructor.newInstance("PePe");
        System.out.println(per);

    }

}
