package basicjava2;

import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        double i, s = 0.0;
        System.out.print("Enter the limit: ");
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        System.out.print("The sum is: ");
        for(i=0; i<=a; i++) {
            s = s + (1/(Math.pow(2,i)));
        }
        System.out.print(s);
    }
}
