package org.interest;

import java.util.Scanner;

public class Interest implements Calculate {
    @Override
    public void simpleInterest(float pa, float r, float t){
        float SI = (pa * r * t)/100;
        System.out.println("Simple Interest : "+SI);
    }
    @Override
    public void compoundInterest(float pa, float r, float t, float n) {

        float amount = pa * (float) Math.pow((1 + r / n), n * t);
        float ci = amount - pa;
        System.out.println("The compound interest is " + ci);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        float pa = scanner.nextFloat();
        System.out.print("Enter the annual interest rate : ");
        float r = scanner.nextFloat();
        System.out.print("Enter the time period : ");
        float t = scanner.nextFloat();
        System.out.print("Enter the number of time interest compounded : ");
        float n = scanner.nextFloat();

        Interest ob = new Interest();
        ob.simpleInterest(pa,r,t);
        ob.compoundInterest(pa,r,t,n);
    }
}
