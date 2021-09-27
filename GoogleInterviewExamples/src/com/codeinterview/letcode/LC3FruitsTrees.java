package com.codeinterview.letcode;

import java.util.*;

public class LC3FruitsTrees {
    public static void main(String... arr){
        LC3FruitsTrees fruitTrees = new LC3FruitsTrees();
        System.out.println("total fruits: " + fruitTrees.totalFruit(new int[]{0}));
        System.out.println("total fruits: " + fruitTrees.totalFruit(new int[]{0,1,2}));
        System.out.println("total fruits: " + fruitTrees.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println("total fruits: " + fruitTrees.totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));

    }

    public int totalFruit(int[] fruits) {
        int start=0, end=0, len = 0, count=0;
        int[] present = new int[fruits.length];
        while (end<fruits.length) {
            if (present[fruits[end]] == 0) {
                count++;
            }
            present[fruits[end]]++;
            end++;
            // bad state
            while (count > 2) {
                present[fruits[start]]--;
                if(present[fruits[start]] == 0) {
                    count--;
                }
                start++;
            }
            // good state
            len = Math.max(len, end - start);
        }

        return len;
    }

    public int totalFruitFaster(int[] fruits) {
        int start=0, end=0, len = 0, count=0;
        Map<Integer, Integer> baskets = new HashMap<>();
        while (end<fruits.length) {
            if (!baskets.containsKey(fruits[end])) {
                baskets.put(fruits[end], 0);
            }
            if (baskets.get(fruits[end]) == 0) {
                count++;
            }
            baskets.put(fruits[end], baskets.get(fruits[end]) + 1);
            end++;
            // full baskets
            while (count > 2) {
                baskets.put(fruits[start], baskets.get(fruits[start]) - 1);
                if(baskets.get(fruits[start]) == 0) {
                    count--;
                }
                start++;
            }
            // check max
            len = Math.max(len, end - start);
        }
        return len;
    }

}
