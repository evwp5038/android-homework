package com.example.evwp5038.jaykitohomwwork;

/**
 * Created by evwp5038 on 2017/7/22.
 */

public class lottery {

    public void kitolottery() {

        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                43, 44, 45, 46, 47, 48, 49};

        int i = 0;
        String p = "";
        int k[] = new int[7];


        for (int o = 0; o < 7; o++) {

            i = (int) (Math.random() * 49 + 1);
            if (a[i - 1] != 0) {
                k[o] = a[i - 1];
                a[i - 1] = 0;

            } else {
                o--;
            }
        }
    }
}
