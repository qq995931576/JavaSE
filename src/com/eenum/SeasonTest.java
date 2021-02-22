package eenum;

/**
 * 一、 枚举类的使用
 * 1. 枚举类的理解: 类的对象只有有限个、确定的。我们称此类为枚举类
 * 2. 当需要定义一组常量时，强烈建议使用枚举类
 * 3. 如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 * <p>
 * 二、 如何定义枚举类
 * 方式一: jdk5.0之前，自定义枚举类
 * 方式二: jdk5.0时，可以使用enum关键词定义枚举类
 * <p>
 * 三、 Enum类中的常用方法:
 * values(): 返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 * valueOf(String str): 可以把一个字符串转换为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如果不是，会运行时异常;
 * toString(): 返回当前枚举类对象常量的名称
 * <p>
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况1: 实现接口，在enum类中实现抽象方法
 * 情况2: 让枚举类的对象分别去实现接口中的抽象方法，每个对象的方法体都可以不一样
 *
 * @author 阿昌
 * @create 2020-10-09 22:40
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn);
    }

}

//自定义枚举类
class Season {
    //1. 声明Season对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2. 私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3. 提供当前枚举类的多个对象:  public static final
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "凌冽寒风");

    //4. 其他诉求1: 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //4. 其他诉求2: 提供toString()

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

}
