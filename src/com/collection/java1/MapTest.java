package com.collection.java1;

import org.junit.Test;

import java.util.*;

/*
一、Map的实现类的结构:
    |----Map: 双列数据,用于存储key-value对 的数据   ---类似于高中的函数:y=f(x)
            |----HashMap: jdk1.2出现;作为Map的主要实现类;线程不安全,效率高;可存储null的key和value;
                  |----LinkedHashMap: jdk1.4出现;保证在遍历map元素时,可以按照添加的顺序实现遍历;是HashMap的子类
                                原因: 在原有的HashMap底层构造基础上,添加了一对引用指针,指向前一个和后一个元素。
                                对于频繁的遍历操作,此类LinkedHashMap执行效率高于HashMap
            |----TreeMap: jdk1.2出现;保证按照添加的key-value对 进行排序,实现排序遍历。此时是考虑对key的自然排序或定制排序。
                          底层使用了红黑树
            |----Hashtable: jdk1.0出现;作为古老的实现类;线程安全,效率低;不能存储null的key和value
                 |----properties: 常用来处理配置文件;是Hashtable的子类;他的key和value都是String类型


    HashMap的底层: 数组 + 链表 (jdk 7 之前)
                  数组 + 链表 + 红黑树 (jdk 8)

    面试题:
    1. HashMap的底层实现原理?---(高频)
    2. HashMap 和 Hashtable的异同?
    3. CurrentHashMap 与 Hashtable的异同?---(暂时不讲)

二.Map结构的理解:
        Map中的key: 无序的、不可重复的,使用Set存储所有的key --->key所在的类要重写equals()方法和hashCode()方法 (以HashMap为例)
        Map中的value: 无序的、可重复的,使用Collection存储所有的value --->value所在的类要重学equals()方法
        一个键值对: key-value构成了一个Entry对象。key和value是Entry对象的属性
        Map中的entry: 无序的、不可重复的,使用Set存储所有的entry



三.*HashMap的底层实现原理?(重要 自己的话描述出来)

以 jdk7 为例说明:
        HashMap map = new HashMap();
        在实例化后，底层创建了长度为16的一维数组,类型为Entry[] table。
        ...可能已经执行过多次put...
        map.put(key,value1);
        首先,调用key1所在类的hashCode()方法,计算key1的哈希值,此哈希值经过某种算法计算后,得到Entry[]数组的存放位置
            如果此位置上的数据为空,此时的key1-value1添加成功。 ----情况1
            如果此位置上的数据不为空,(此位置上存在一个或多个数据(以链表形式存在)),比较key1与已经存在的一个或多个数据的哈希值:
                如果key1的哈希值与已经存在的数据的哈希值都不相同,此时key1-value1添加成功。 ----情况2
                如果key1的哈希值与某一个数据(key2-value2)的哈希值的相同,继续比较: 调用key1所在类的equals(key2)方法,进行比较:
                    如果equals()返回false:此时key1-value1添加成功。 ----情况3
                    如果equals()放回true:使用value1替换value2的值。

        补充: 关于情况2和情况3: 此时key1-value1和原来的数据以链表的方式存储。

        在不断的添加过程中，会涉及到扩容问题: 默认的扩容方式:当超出threshold临界值(且要存放的位置非空)时,扩容为原来容量的2倍,并将原有的数据复制过来。

jdk8 相较于jdk7在底层实现方面的不同:
        1. new HashMap():底层没有创建一个长度为16的Entry[]
        2. jdk 8 底层的数组是: Node[],而非Entry[]
        3. 首次调用put()方法时,底层创建长度为16的数组
        4. jdk 7 底层结构只有: 数组 + 链表。 jdk 8 底层结构: 数组 + 链表 + 红黑树。
            形成链表时,7上8下(jdk7 是新的元素指向旧的的元素;jdk8 是旧的元素指向新的元素)

            当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时,
            此时此索引位置上的所有数据改为使用红黑树存储。

         DEFAULT_INITIAL_CAPACITY ： HashMap的默认容量: 16
         DEFAULT_LOAD_FACTOR : HashMap的默认加载因子: 0.75
         threshold: 扩容的临界值 = 容量 * 加载因子 : 16 * 0.75 => 12
         TREEIFY_THRESHOLD： Bucket中链表长度大于该默认值,转化为红黑树 : 8
         MIN_TREEIFY_CAPACITY: 桶中的Node被树划时最小的hash表容量: 64

四.LinkedHashMap的底层实现原理(了解)

        static class Entry<K,V> extends HashMap.Node<K,V> {
        Entry<K,V> before, after;//能够记录添加元素的先后顺序
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
          }
        }

五.Map中定义的方法:

-添加、删除、修改操作:
    1.Object put(Object key,Object value): 将指定key-value添加到(或修改)当前map对象中
    2.void putAll(Map m): 将m中的所有key-value对 存放到当前map中
    3.Object remove(Object key): 移除指定key的key-value对,并返回value
    4.void clear(): 清空当前map中的所有数据
-元素查询的操作:
    1.Object get(Object key): 获取指定key对应的value
    2.boolean containsKey(Object key): 是否包含指定的key
    3.boolean containsValue(Object value): 是否包含指定的value
    4.int size(): 返回map中的key-value对 的个数
    5.boolean isEmpty(): 判断当前map是否为空
    6.boolean equals(Object obj): 判断当前map和参数对象obj是否相等
-元视图操作的方法:
    1.Set keySet(): 返回所有key构成的Set集合
    2.Collection values(): 返回所有value构成的Collection集合
    3.Set entrySet(): 返回所有key-value对 构成的Set集合

总结: 常用方法
添加: put(Object key,Object value)
删除: remove(Object key)
修改: put(Object key,Object value)
查询：get(Object key)
长度: size()
遍历: keySet() / values() / entrySet()

 */
public class MapTest {
    /*
    -元视图操作的方法:
    1.Set keySet(): 返回所有key构成的Set集合
    2.Collection values(): 返回所有value构成的Collection集合
    3.Set entrySet(): 返回所有key-value对 构成的Set集合
     */
    @Test
    public void test5() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("CC", 125);
        map.put(95430, 123);

        //遍历所有的key集:    keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        //遍历所有的value集:  value()
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }

        System.out.println();

        //遍历所有的key-value:   entrySet()
        //方式一: entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
        System.out.println();
        //方式二:
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "====" + value);
        }

    }


    /*
    -元素查询的操作:
    1.Object get(Object key): 获取指定key对应的value
    2.boolean containsKey(Object key): 是否包含指定的key
    3.boolean containsValue(Object value): 是否包含指定的value
    4.int size(): 返回map中的key-value对 的个数
    5.boolean isEmpty(): 判断当前map是否为空
    6.boolean equals(Object obj): 判断当前map和参数对象obj是否相等
    */
    @Test
    public void test4() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("CC", 125);
        map.put(95430, 123);

        //1.Object get(Object key): 获取指定key对应的value
        System.out.println(map.get(95430));//123
        System.out.println(map.get("QQ"));//null

        //2.boolean containsKey(Object key): 是否包含指定的key
        System.out.println(map.containsKey("AA"));//true
        System.out.println(map.containsKey("HH"));//false

        //3.boolean containsValue(Object value): 是否包含指定的value
        System.out.println(map.containsValue(123));//true
        System.out.println(map.containsValue(9999));//false

        //4.int size(): 返回map中的key-value对 的个数
        System.out.println(map.size());//3

        //5.boolean isEmpty(): 判断当前map是否为空
        System.out.println(map.isEmpty());//false

        //6.boolean equals(Object obj): 判断当前map和参数对象obj是否相等
        Map map1 = new HashMap();
        map1.put("AA", 123);
        map1.put("CC", 125);
        map1.put(95430, 123);
        System.out.println(map.equals(map1));//true

    }


/*
-添加、删除、修改操作:
    1.Object put(Object key,Object value): 将指定key-value添加到(或修改)当前map对象中
    2.void putAll(Map m): 将m中的所有key-value对 存放到当前map中
    3.Object remove(Object key): 移除指定key的key-value对,并返回value
    4.void clear(): 清空当前map中的所有数据
 */

    @Test
    public void test3() {
        //1. Object put(Object key,Object value): 将指定key-value添加到(或修改)当前map对象中
        Map map = new HashMap();
        //添加
        map.put("AA", 123);//key值只能有一个
        map.put("CC", 125);
        map.put(95430, 123);
        //修改,替换了之前key的Value值
        map.put("AA", 25);

        System.out.println(map);//{AA=25, CC=125, 95430=123}

        //2. void putAll(Map m): 将m中的所有key-value对 存放到当前map中
        Map map1 = new HashMap();
        map.put("EE", 125);
        map.put("FF", 123);

        map.putAll(map1);
        System.out.println(map);//{AA=25, CC=125, EE=125, FF=123, 95430=123}

        //3.Object remove(Object key): 移除指定key的key-value对,并返回value
        Object value = map.remove("CC");
        Object value2 = map.remove("CCC");
        System.out.println(value2);//null   "CCC"不存在,返回null
        System.out.println(value);//125     返回了key"CC"的value值125
        System.out.println(map);//{AA=25, EE=125, FF=123, 95430=123}

        //4.void clear(): 清空当前map中的所有数据
        map.clear();//清空map数据,不是将其赋为null,与 map = null操作不同
        System.out.println(map);//{}
        System.out.println(map.size());//0
    }

    @Test
    public void test2() {
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(159, "AA");
        map.put(357, "BB");
        map.put(456, "CC");
        map.put(258, "DD");

        System.out.println(map);//{159=AA, 357=BB, 456=CC, 258=DD}

    }

    @Test
    public void test1() {
        Map map = new HashMap();
        map.put(null, null);//HashMap可以存储null的key和value
        Map map1 = new Hashtable();
//        map1.put(null,null);//Hashtable不可以存储null的key和value 报错:NullPointerException


    }


}
