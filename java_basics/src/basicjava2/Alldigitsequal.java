package basicjava2;

import java.util.Scanner;

public class Alldigitsequal {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int temp = a, rem = 0, r =0;
        while(temp != 0) {
        	rem = temp/10;
        	temp = temp%10;
        	
        }
    }
}
