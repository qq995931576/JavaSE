package reflection.java1;

import java.io.Serializable;

/**
 * @author 阿昌
 * @create 2020-10-14 22:38
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物进食");
    }

}
