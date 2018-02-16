package com.fa.demo.pages;

public class MyBase extends MySuper {
    int b = 3;

    void myMethod()
    {
        System.out.print("y" + b);
    }
    public static void main(String[] args)
    {
        MyBase mySub = new MyBase();
    }
}
