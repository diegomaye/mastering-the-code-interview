package com.codeinterview.book;

public class CCIEx13URLify {
    private static String prueba1 = "Hola que tal?    ";
    private static String prueba2 = "Hola todo bien y vos        ";
    private static String prueba3 = "Hola buenos dias que tal        ";
    private static String prueba4 = "Chau adios que te vaya bien          ";

    public static void main(String... arr){
        System.out.println(String.format("Result: %s", repaceSpace(prueba1,13)));
        System.out.println(String.format("Result: %s", repaceSpace(prueba2,20)));
        System.out.println(String.format("Result: %s", repaceSpace(prueba3,24)));
        System.out.println(String.format("Result: %s", repaceSpace(prueba4,27)));
    }

    private static String repaceSpace(String frase, int length){
        char[] letters = frase.toCharArray();
        int count = 0;
        for(int i = 0; i<length; i++){
            if(letters[i] == ' '){
                count++;
            }
        }
        if(frase.length() == length+count*2) {
            char[] result = new char[length + count*2];
            int posResult = 0;
            for (int i = 0; i < length; i++) {
                if (letters[i] == ' ') {
                    result[posResult] = '%';
                    result[posResult] = '2';
                    result[posResult] = '0';
                    posResult = posResult + 3;
                } else {
                    result[posResult] = letters[i];
                    posResult++;
                }
            }
            return String.valueOf(result);
        }
        else return null;
    }
}
