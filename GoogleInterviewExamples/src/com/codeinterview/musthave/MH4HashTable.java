package com.codeinterview.musthave;

import java.util.*;

public class MH4HashTable {

    public static void main(String... args){
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Stack<String> stack = new Stack<>();
        LinkedList<String> val = new LinkedList<>();
        map.put('a', 1);
        int a = map.get('a');
        map.containsKey('a');
        map.isEmpty();
        map.clear();

        for(Map.Entry<Character, Integer> item:map.entrySet()){
            set.add(item.getValue());
            stack.push(String.valueOf(item.getKey()));//lo pone al final
        }

        stack.pop();
        stack.peek();
        stack.remove("a");
        Arrays.sort(set.toArray());
    }
}
