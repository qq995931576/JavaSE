package com.exception.demo01;

public class Test {

    public static void main(String[] args) {
        new Test().test(11, 0);

    }

    //假设这个方法中，处理不了这个异常；方法上抛出异常
    //throw是制造异常，throws是抛出异常
    public void test(int a, int b) throws ArithmeticException {//在方法上主动抛出 throws
        if (b == 0) {
            throw new ArithmeticException();// 主动在方法里抛出异常 一般在方法中使用  throw

        }
        System.out.println(a / b);
    }
}

/*
       int a = 1;
        int b = 0;

        //假设要捕获多个异常： 从小到大

        try {// try 监控区域


        }catch (Exception e){//   catch(想要捕获的异常类型) 捕获异常
            System.out.println("Exception");
        }catch (Error t){
            System.out.println("Error");
        }catch(Throwable q){
            System.out.println("Throwable");
        }finally{// 处理善后工作，不管出不出异常，都会执行finally
            System.out.println("finally");
        }

        //finally 可以不要，假设IO，资源，关闭！
 */