package com.eagle6.controller;

import java.util.ArrayList;

public class testing {
    public static void main(String[] args) {
        // for (int i = 0; i < 2000; i++) {
        //     int random = (int)(Math.random() * 28 + 1);
        //     System.out.println(random);
        // }
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        a.remove(a.size()-1);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a);
        }

    }
}
