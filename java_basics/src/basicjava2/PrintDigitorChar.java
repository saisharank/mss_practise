package basicjava2;

import java.util.Scanner;

public class PrintDigitorChar {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Character: ");
        char a = sc.next().charAt(0);
        if (a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z')
            System.out.println("You have entered "+a);
        System.out.print("Enter Digit: ");
        int b = sc.nextInt();
        System.out.println("You have entered "+b);
    }
}
