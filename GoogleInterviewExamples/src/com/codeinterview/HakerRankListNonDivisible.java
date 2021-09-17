package com.codeinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HakerRankListNonDivisible {
    public static void main(String... str){
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(7);
        arr.add(2);
        arr.add(4);
        //System.out.println(nonDivisibleSubset(3, arr));
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(278);
        arr2.add(576);
        arr2.add(496);
        arr2.add(727);
        arr2.add(410);
        arr2.add(124);
        arr2.add(338);
        arr2.add(149);
        arr2.add(209);
        arr2.add(702);
        arr2.add(282);
        arr2.add(718);
        arr2.add(771);
        arr2.add(575);
        arr2.add(436);
        System.out.println(nonDivisibleSubset(7, arr2));
    }
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        HashSet<Integer> maxPermutation = new HashSet<Integer>();
        int count = 0;
        for(Integer first:s)
            for(int i = s.indexOf(first) + 1; i < s.size() ; i++){
                Integer second = s.get(i);
                Integer sum = first + second;
                int mod = sum%k;
                if(mod != 0){
                    if(!maxPermutation.contains(first)){
                        maxPermutation.add(first);
                        count++;
                    }
                    if(!maxPermutation.contains(second)){
                        maxPermutation.add(second);
                        count++;
                    }
                }
            }
        return count;
    }
}
