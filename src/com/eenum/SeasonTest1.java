package eenum;

/**
 * 方式二:
 * 使用enum关键词定义枚举类
 * 说明: 定义的枚举类默认继承于java.lang.Enum类
 *
 * @author 阿昌
 * @create 2020-10-10 21:24
 */
interface Info {
    void show();
}

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;
//      System.out.println(Season1.class.getSuperclass());

        //toString(): 返回枚举类对象的名称
        System.out.println(autumn.toString());

        System.out.println("======================================");

        //values(): 返回所有枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String Object): 返回枚举类中对象名是objName的对象。
        //如果没有objName的枚举类对象，则抛异常: IllegalArgumentException
        Season1 spring = Season1.valueOf("SPRING");
        System.out.println(spring);

        System.out.println("====================");

        autumn.show();


    }


}

//方式二:使用enum关键字定义枚举类
enum Season1 implements Info {
    //1. 提供当前枚举类的对象，多个对象之间用 "," 隔开，末尾的对象用 ";" 结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("这是一个春天");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("这是一个夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("这是一个秋天");
        }
    },
    WINTER("冬天", "凌冽寒风") {
        @Override
        public void show() {
            System.out.println("这是一个冬天");
        }
    };

    //2. 声明Season对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;


    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4. 其他诉求1: 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}
