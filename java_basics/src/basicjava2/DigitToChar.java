package basicjava2;

import java.util.Scanner;

public class DigitToChar {
    public static void main(String[] args) {
        System.out.print("Enter the number from 0 to 9: ");
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case 1: System.out.println("One"); break;
            case 2: System.out.println("Two"); break;
            case 3: System.out.println("Three"); break;
            case 4: System.out.println("Four"); break;
            case 5: System.out.println("Five"); break;
            case 6: System.out.println("Six"); break;
            case 7: System.out.println("Seven"); break;
            case 8: System.out.println("Eight"); break;
            case 9: System.out.println("Nine"); break;
            case 0: System.out.println("Zero"); break;
            default: System.out.println("Unknown"); break;
        }
    }
}
