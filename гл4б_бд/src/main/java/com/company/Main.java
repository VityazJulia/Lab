package com.company;

import java.util.Scanner;
import java.io.*;
import dbutil.DBUtil;
import entity.Vegetable;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        DBUtil dbUtils = new DBUtil();
        Scanner in = new Scanner(System.in);

        Scanner scanner = new Scanner(System.in);
    int choice = -1;

        System.out.println("What do you want to cook today?");

        while (choice != 0) {
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Show recipe");
            System.out.println("2. Sort ingredients by calories");
            System.out.println("3. Get ingredients for calories");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    String p;
                    p = dbUtils.getTable();


                        System.out.println(p);

                    break;
                case 2:
                    String s;
                    s = dbUtils.getTableSorted();

                        System.out.println(s);

                    break;
                case 3:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Input lower value: ");
                    double lower = scanner1.nextDouble();
                    System.out.print("Input upper value: ");
                    double upper = scanner1.nextDouble();
                    String s1;
                    s1 = dbUtils.getCaloriesRange(lower, upper);

                        System.out.println(s1);


                    break;


                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }

        }
}
}
