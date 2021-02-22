package java8new.java3;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类: 为了在程序中避免出现空指针异常而创建的。
 * <p>
 * 通常的方法: ofNullable(T t): t可以为null
 * orElse(T t): t为备胎
 * get(): 如果调用对象包含值，返回该值，否则抛异常
 * empty(): 创建的Optional对象内部的value = null
 * <p>
 * get()通常与of()搭配使用。用于获取内部封装的数据value
 *
 * @author 阿昌
 * @create 2020-10-22 20:01
 */
public class OptionalTest {

    /*
    创建Optional类对象的方式:
    - Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
    - Optional.empty() : 创建一个空的 Optional 实例
    - Optional.ofNullable(T t)：t可以为nul
     */


    //- Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
    @Test
    public void test1() {
        Girl girl = new Girl();
//        girl = null;  //报错: NullPointerException
        Optional<Girl> optional = Optional.of(girl);
        System.out.println(optional);// Optional[Girl{name='null'}]

    }

    //- Optional.ofNullable(T t)：t可以为nul
    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optional = Optional.ofNullable(girl);
        System.out.println(optional);// Optional.empty

    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    //以前出现空指针的情况
    @Test
    public void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);

    }

    //getGirlName()方法的优化
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = new Girl();
            if (girl != null) {
                String girlName = girl.getName();
                return girlName;
            }
        }
        return null;
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);

    }

    //使用Optional类实现方法优化
    public String getGirlName2(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        //此时的boy1一定非空
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("花花")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //此时girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("静香"));
        return girl1.getName();
    }

    @Test
    public void test5() {
//        Girl girl = new Girl();
//        Boy boy = new Boy(girl);//girl是null，返回 静香
        Boy boy = null;//boy是null，返回 花花
        Boy boy1 = new Boy(new Girl("红红"));//正常情况，返回 红红
        String s = getGirlName2(boy);
        System.out.println(s);

    }


}
