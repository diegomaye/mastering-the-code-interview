package com.codeinterview.musthave;

import java.util.*;

public class MH7SortingFundamentals {
    List<String> list = Arrays.asList("Buenos Aires", "Buenos Aires", "Buenos Aires", "Córdoba", "La Plata", "La Plata", "Paraguay");
    public static void main(String... arr){
        String[] arr3 = { "Juan", "Pedro", "Luis", "Martin", "Matias", "Juan", "Luis", "Pedro", "Juan", "Martin", "Miguel"};
        System.out.println(withHash(Arrays.asList(arr3)));
    }

    public static List<String> withHash(List<String> input){
        HashMap<String, Integer> map = new HashMap<>();
        for(String query : input){
            if(map.containsKey(query)){
                int amount = map.get(query);
                map.put(query, amount+1);
            } else {
                map.put(query, 0);
            }
        }
        print(map);
        //return selectionSort(map);
        return bubbleSort(map);
    }

    /**
     * With this exercise was proved that bubble sort could be used to order number list
     * with repeated numbers & in the example a hashmap is used instead of an array.
     * Big O = O(n^2)
     * */
    private static List<String> bubbleSort(HashMap<String, Integer> map){
        List<String> orderedKey = new ArrayList<>(map.keySet());
        int i = 0;
        for(String key: orderedKey){
            for(int j = 0; j < orderedKey.size()-i-1; j++){
                String inPos = orderedKey.get(j);
                String inNext = orderedKey.get(j+1);
                if(map.get(inPos) < map.get(inNext)){
                    swap(orderedKey, j);
                }
            }
            i++;
        }
        return orderedKey;
    }

    /**
     * Search the max element (with id) replace position
     * Big O = O(n^2)
     * */
    private static List<String> selectionSort(HashMap<String, Integer> map){
        List<String> orderedKey = new ArrayList<>(map.keySet());
        for(int i = 0; i < orderedKey.size(); i++) {
            int idMax = i;
            for (int j = i + 1; j < orderedKey.size(); j++){
                if(map.get(orderedKey.get(j))>map.get(orderedKey.get(idMax))){
                    idMax = j;
                }
            }
            swap(orderedKey,i,idMax);
        }
        return orderedKey;
    }

    private static List<String> quickSort(HashMap<String, Integer> map){
        List<String> orderedKey = new ArrayList<>(map.keySet());
        return orderedKey;
    }

    private static void swap(List<String> orderedKey, int i){
        swap(orderedKey, i, i+1);
    }

    private static void swap(List<String> orderedKey, int i, int j){
        String value = orderedKey.get(i);
        orderedKey.set(i, orderedKey.get(j));
        orderedKey.set(j, value);
    }

    private static void print(HashMap<String, Integer> map){
        for(String key:map.keySet())
            System.out.println("(" + key + ", " + map.get(key) + ")");
    }

}
