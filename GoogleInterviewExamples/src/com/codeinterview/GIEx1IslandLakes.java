package com.codeinterview;

/**
 * Imagine an island that is in the shape of a bar graph. When it rains, certain areas of the island
 * fill up with rainwater to form lakes. Any excess rainwater the island cannot hold in lakes will run off
 * the island to the west or east and drain into the ocean.
 *
 * Given an array of positive integers representing 2-D bar heights, design an algorithm (or write a function)
 * that can compute the total volume (capacity) of water that could be held in all lakes on such an island given
 * an array of the heights of the bars. Assume an elevation map where the width of each bar is 1.
 * */

public class GIEx1IslandLakes {
    private static int[] arr1 = new int[]{1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
    private static int[] arr2 = new int[]{1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
    private static int[] arr3 = new int[]{1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
    private static int[] arr4 = new int[]{1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};

    public static void main (String... arr){
        System.out.println(trap(arr1));
    }

    public static int trap(int[] height) {
        int trappedWater = 0;

        return trappedWater;
    }

    private static int[] fillVolumeMeter(int[] height){
        int[] volumeMeter =  new int[height.length];
        int peek = -1;
        int totalTrapped = 0;
        for(int i = 1; i < height.length; i++){
            int trappedWater = ((peek != -1)?peek:volumeMeter[i-1]) - volumeMeter[i];
            if(trappedWater > 0){
                if (peek == -1) peek = volumeMeter[i-1];
                totalTrapped += trappedWater;
            } else if(trappedWater <= 0) {
                peek = -1;
            }
        }
        return volumeMeter;
    }

}
