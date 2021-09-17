package com.codeinterview.letcode;

import java.util.HashSet;
import java.util.Set;

public class LC1AliceCandyBag {
    public int distributeCandies(int[] candyType) {
        Set<Integer> aliceCandyBag = new HashSet<>();
        aliceCandyBag.add(candyType[0]);
        for(int i=0; i<candyType.length && aliceCandyBag.size()<candyType.length/2; i++){
            if(!aliceCandyBag.contains(candyType[i])){
                aliceCandyBag.add(candyType[i]);
            }
        }
        return aliceCandyBag.size();
    }
}
