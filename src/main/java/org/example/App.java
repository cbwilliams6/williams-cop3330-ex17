package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Christian Williams
 */

public class App
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        final int legalAge = 16;

        boolean test = false;
        int gender = 0;
        int ounces = 0;
        int weight = 0;
        int hours = 0;

        do {
            try {
                System.out.println("Enter a 1 if you are male or a 2 if you are female: ");
                gender = input.nextInt();
                test = true;
            } catch (InputMismatchException e) {
                System.out.println("You have to enter a number...");
                input.nextLine();
            }
        } while(!test);

        test = false;
        do {
            try {
                System.out.println("How many ounces of alcohol did you have? ");
                ounces = input.nextInt();
                test = true;
            } catch (InputMismatchException e) {
                System.out.println("You have to enter a number...");
                input.nextLine();
            }
        } while(!test);

        test = false;
        do {
            try {
                System.out.println("What is your weight, in pounds? ");
                weight = input.nextInt();
                test = true;
            } catch (InputMismatchException e) {
                System.out.println("You have to enter a number...");
                input.nextLine();
            }
        } while(!test);

        test = false;
        do {
            try {
                System.out.println("How many hours has it been since your last drink? ");
                hours = input.nextInt();
                test = true;
            } catch (InputMismatchException e) {
                System.out.println("You have to enter a number...");
                input.nextLine();
            }
        } while(!test);

        double ratio;
        if(gender == 1){
            ratio = 0.73;
        }
        else{
            ratio = 0.66;
        }
        double bac = (ounces * 5.14 / weight * ratio) - (0.015 * hours);
        System.out.println("Your BAC is " + String.format("%.6f", bac) + "\n" +
                ((bac >= 0.08) ? "It is not legal for you to drive." : "It is legal for you to drive."));
    }
}