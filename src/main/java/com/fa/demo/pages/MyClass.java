package com.fa.demo.pages;

public class MyClass {
    static int x;
    void print() {
        int i = 0;
        while (i < 3) {
            x++;
            for (int j = 0; j < 4; j++) {
                x++;
                if (j == 2)
                    return;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        new MyClass().print();
        System.out.print(x);
    }
}
