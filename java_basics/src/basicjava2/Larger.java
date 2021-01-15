package basicjava2;

import java.util.Scanner;

public class Larger {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first value: ");
        int x = sc.nextInt();
        System.out.print("Enter second value: ");
        int y = sc.nextInt();
        if (x>y)
            System.out.println(x+" is greater");
        else System.out.println(y+" is greater");
    }
}
