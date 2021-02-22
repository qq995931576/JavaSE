package reflection.java2;

import org.junit.Test;
import reflection.java1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author 阿昌
 * @create 2020-10-15 20:20
 */
public class MethodTest {
    @Test
    public void test1() {

        Class<Person> clazz = Person.class;

        //getMethods(): 获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println();

        //getDeclaredMethods(): 获取当前运行时类中声明的所有方式    (不包含父类声明的方法)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

    }

    //@Xxxx
    //权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException{}
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            //获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            //获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //获取返回值类型
            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + "\t");

            //获取方法名
            System.out.print(m.getName());
            System.out.print("(");

            //获取形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args_ ");
                        break;
                    } else {
                        System.out.print(parameterTypes[i].getName() + " args_ " + i + ",");
                    }

                }
            }
            System.out.print(")");

            //获取抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }
    }

}
