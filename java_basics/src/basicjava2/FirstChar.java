package basicjava2;

import java.util.Scanner;

public class FirstChar {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Initial: ");
        char YourFirstInitial = sc.next().charAt(0);
        System.out.print("You have entered "+YourFirstInitial);
    }
}
