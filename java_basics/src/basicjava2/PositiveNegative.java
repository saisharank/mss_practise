package basicjava2;

import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        if(a>0) {
            System.out.println("You have entered a positive number");
        }
        else {
            System.out.println("You have entered a negative number");
        }
    }
}
