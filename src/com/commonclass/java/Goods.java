package com.commonclass.java;


//商品类
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //重写compareTo(obj)方法的规则:
    //            如果当前对象this大于形参对象obj，则返回正整数；
    //            如果当前对象this小于形参对象obj，则返回负整数；
    //            如果当前对象this等于形参对象obj，则返回零。
    //重写compareTo()方法
    //自定义排序，按照什么方式进行排序，如按照价格从低到高排序,再按照商品名字从低到高排序
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            //方式一
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return this.name.compareTo(goods.name);
            }
            //方式二：
//            Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致!");
    }
}







