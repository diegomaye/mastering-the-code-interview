package com.company;
/**
 * Class just take first 2 elements from div array, improvements need to be made to support multiple div numbers
 * */
public class Ex1SumDivisibleBy {

    private Ex1SumDivisibleBy(){
    }

    public static void execute(int range, int... div){
        Ex1SumDivisibleBy ex= new Ex1SumDivisibleBy();
        System.out.println(String.format("El total de la suma de los divisibles por 3 y 5 es: %s", ex.sum(range, div)));
        System.out.println(String.format("El total optimizado de la suma de los divisibles por 3 y 5 es: %s", ex.sumOptimized(div[0], range) + ex.sumOptimized(div[1], range) - ex.sumOptimized(15, range)));
    }

    private int sum(int range, int... div){
        int total= 0;
        for(int i= 0; i<range; i++){
            if(i%div[0] == 0 || i%div[1] == 0){
                total += i;
            }
        }
        return total;
    }
    /**
     * Let’s look at the details of our function and take as example n=3.
     * We would have to add:
     * 3+6+9+12+......+999=3*(1+2+3+4+...+333)
     * For n=5 we would get:
     * 5+10+15+...+995=5*(1+2+....+199)
     * Now note that 199=995/5 but also 999/5 rounded down to the nearest integer
     * Now note that 199=995/5 but also 999/5 rounded down to the nearest integer.
     * In many programming languages there exists a separate operator for that: div or \.
     * If we now also note that 1+2+3+...+p=½*p*(p+1) our program becomes
     * */
    private int sumOptimized(int div, int range){
        int tot = range/div;
        return div*(tot*(tot+1))/2;
    }
}
