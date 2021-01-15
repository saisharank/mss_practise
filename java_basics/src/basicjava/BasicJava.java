package basicjava;

import java.util.Scanner;

public class BasicJava {

	public static void main(String[] args) {
		int i,j,a,b,c;
        i = 67;
        System.out.println("The integer part of 23.1256 is" + (int)23.1256);
        j = 134;
        System.out.println("J:" +j);
        System.out.println("Square of "+ j + " is " +(int)Math.pow(j, 2));
        System.out.println("Cube of "+ j + " is " +(int)Math.pow(j, 3));
        System.out.println("Sum of i & j is " +(i+j));
        System.out.println("Difference between i & j is " +(j-i));
        System.out.println("Product of i & j is " +(i*j));
        System.out.println("Divison of i & j is " +(double)(j/i));
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        a = sc.nextInt();
        System.out.print("Enter the value of b: ");
        b = sc.nextInt();
        System.out.print("Enter the value of c: ");
        c = sc.nextInt();
        System.out.println("The sum of "+a+","+b+" and "+c+" is "+(a+b+c));
        System.out.println("The sum of "+a+","+b+" and "+c+" is "+(float)((a+b+c)/3));
        System.out.print("Enter the radius r: ");
        int r = sc.nextInt();
        System.out.println("The area of the circle is "+(Math.PI*(r*r)));
        String s1 = "Miracle";
        String s2 = "World";
        System.out.println("Concatenated String "+(s1+" "+s2));
        int dollar = 53;
        System.out.println("The value of dollar is "+dollar);
        dollar = 56;
        System.out.println("The updated value of dollar is "+dollar);
        dollar = 59;
        System.out.println("The recent value of dollar is "+dollar);
        int x  = 50;
        int y = 60;
        int z = x+y;
        System.out.println("The value of z is "+z);
        int loan_amount = 100000;
        double rate = 0.25;
        double interest = loan_amount * rate;
        System.out.println("The Interest amount to be paid is Rs."+interest+"/-");

	}

}
