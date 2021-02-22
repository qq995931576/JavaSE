package reflection.java3;

/**
 * 静态代理举例
 * <p>
 * 特点: 代理类和被代理类在编译期间，就确定下来了。
 *
 * @author 阿昌
 * @create 2020-10-17 19:40
 */


interface ClothFactory {

    void produceCloth();

}


//代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工程做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些收尾工作");
    }

}


//被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }

}

//测试
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类对象
        NikeClothFactory ncf = new NikeClothFactory();
        //创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(ncf);

        proxyClothFactory.produceCloth();

    }

}
