package com.codedojo;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Ex1MyMF {

    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
        System.out.println(String.format("Para 1: %d", mostFrequent(array1)));
        System.out.println(String.format("Para 2: %d", mostFrequent(array2)));
        System.out.println(String.format("Para 3: %d", mostFrequent(array3)));
        System.out.println(String.format("Para 4: %d", mostFrequent(array4)));
        System.out.println(String.format("Para 5: %d", mostFrequent(array5)));
    }

    // Implement your solution below.
    public static Integer mostFrequent(int[] givenArray) {
        HashMap<Integer,Integer> map = new HashMap();
        if(givenArray == null || givenArray.length==0){
            return null;
        }
        else {
            for(int i = 0; i < givenArray.length; i++){
                if(map.containsKey(givenArray[i])){
                    map.put(givenArray[i], map.get(givenArray[i]) + 1);
                }
                else{
                    map.put(givenArray[i],1);
                }
            }
            return mostFrequent(map);
        }
    }

    public static Integer mostFrequent(HashMap listWithSums){
        Iterator it = listWithSums.entrySet().iterator();
        Integer max = 0, key = 0;
        while(it.hasNext()){
            Entry<Integer,Integer> pair = (Entry)it.next();
            if(pair.getValue() > max) {
                max = pair.getValue();
                key = pair.getKey();
            }
        }
        return key;
    }
}
