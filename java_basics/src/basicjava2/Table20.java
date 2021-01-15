package basicjava2;

import java.util.Scanner;

public class Table20 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i=0;
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        System.out.println("Generating the "+a+" table");
        do {
            System.out.format("%d * %d = %d \n", a, i, a * i);
            i++;
        }while (i <= 20);
    }
}
