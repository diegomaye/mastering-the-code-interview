package com.codeinterview;

public class Solution {

    public static void main(String... arr){
        System.out.println("Para la key: 5F3Z-2e-9-w, el valor es:");
        System.out.println((new Solution()).licenseKeyFormatting("5F3Z-2E9W",4));
        System.out.println("Para la key: 2-5g-3-J, el valor es:");
        System.out.println((new Solution()).licenseKeyFormatting("2-5g-3-J",2));
    }

    public String licenseKeyFormatting(String s, int k) {
        char[] characters = s.toCharArray();
        int length= numberOfCharacters(characters)/k+((numberOfCharacters(characters)%k!=0)?1:0);
        String[] groups = new String[length];
        StringBuilder keyResult = new StringBuilder();
        int group = 0;
        int groupId = 0;
        for(int i = characters.length - 1; i >= 0; i--){
            if(characters[i] != '-'){
                keyResult.insert(0, characters[i]);
                group++;
            }
            if(group == k || i == 0) {
                if(groupId < groups.length) {
                    groups[groupId] = keyResult.toString().toUpperCase();
                    keyResult.delete(0, keyResult.length());
                }
                group = 0;
                groupId++;
            }
        }
        keyResult.delete(0, keyResult.length());
        for (int i = groups.length-1; i >= 0; i--){
            System.out.println(groups[i]);
            if(i != 0){
                keyResult.append(groups[i] + "-");
            }
            else{
                keyResult.append(groups[i]);
            }
        }
        return keyResult.toString();
    }

    private String grouping(char[] charPart, int pos, int size){
        StringBuilder builder = new StringBuilder();
        int group = 0;
        while(group != size){
            if(charPart[pos]!='-'){
                builder.append(charPart[pos]);
                group++;
            }
        }
        return builder.toString();
    }

    private int numberOfCharacters(char[] characters){
        int i = 0;
        for(char ch:characters)
            if(ch=='-')
                i++;
        return characters.length - i;
    }
}
