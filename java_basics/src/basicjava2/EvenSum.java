package basicjava2;

import java.util.Scanner;

public class EvenSum {
    public static void main(String[] args){
        int i=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int a = sc.nextInt();
        System.out.print("Even Numbers from 1 to "+a+" are: ");
        do {
            for(i=1; i<=a; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        }while (i <= a);
    }
}
