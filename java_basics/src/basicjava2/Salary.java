package basicjava2;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args){
        System.out.print("Enter the Your Salary: ");
        Scanner sc=new Scanner(System.in);
        int YourSalary = sc.nextInt();
        System.out.print("Your Salary is Rs."+YourSalary+"/-");
    }
}
