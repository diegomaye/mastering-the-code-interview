package com.codeinterview;

import java.util.*;

public class Program {
    String[] values = new String[]{"Como funcionan los cohetes?", "Hello LeetCoder", "Mario Baracus", "Maxi Lopez", "Patineta Voladora", "Como funcionan los cohetes?", "Hello LeetCoder", "Hello LeetCoder", "Patineta Voladora", "Como funcionan los cohetes?", "Hello LeetCoder", "Como funcionan los cohetes?"};
    public static void main(String[] arr){
        System.out.println((new Program()).nonConstructibleChange(new int[]{5, 7, 1, 1, 2, 3, 22}));
    }

    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birds = new HashMap<>();
        for(int i = 1; i < arr.size(); i++){
            int amount = birds.getOrDefault(arr.get(i), 0);
            birds.put(arr.get(i), amount+1);
        }
        Set<Integer> typeset = birds.keySet();
        List<Integer> typesList = new ArrayList<>(typeset);
        Collections.sort(typesList);
        int max = 0;
        int resultType = 0;
        for(Integer type: typesList){
            if(max < birds.get(type)){
                max = birds.get(type);
                resultType = type;
            }
        }
        return resultType;
    }


    public int nonConstructibleChange(int[] coins) {
        boolean minChange = false;
        int minNum = 0;
        int maxValueInArray = 0;
        for(int i = 0; i < coins.length; i++){
            if(maxValueInArray < coins[i]){
                maxValueInArray = coins[i];
            }
        }
        System.out.println(maxValueInArray);
        while(!minChange && minNum < maxValueInArray){
            minNum++;
            for(int i = 0; i < coins.length; i++){
                if(coins[i] == minNum){
                    break;
                }
                if(i == coins.length){
                    System.out.println("LO ENCONTRE");
                    minChange = true;
                }
            }
        }
        return minNum;
    }
}
