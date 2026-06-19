package main;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Digite 2 numeros:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        try {
            double result = (double)a / (double)b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        scan.close();
    }   
}