package basicjava2;

import java.util.Scanner;

public class EvenCount {
    public static void main(String[] args){
        int sum = 0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int a = sc.nextInt();
        for(int i = 1; i <= a; i++){
            if((i % 2) == 0) {
                sum = sum+i;
            }
        }
        System.out.print("Even Numbers from 1 to "+a+" are: "+sum);
    }
}
