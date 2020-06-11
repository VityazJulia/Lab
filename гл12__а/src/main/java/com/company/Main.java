package com.company;

import dbutil.DBUtils;
import entity.Person;
import entity.Letter;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBUtils dbUtils = new DBUtils();
        Scanner in = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Найти пользователя, длина писем которого наименьшая");
            System.out.println("2. Вывести информацию о пользователях, а также количестве полученных\n" +
                    "и отправленных ими письмах");
            System.out.println("3. Вывести информацию о пользователях, которые получили хотя бы одно\n" +
                    "сообщение с заданной темой");
            System.out.println("4. Вывести информацию о пользователях, которые не получали сообщения\n" +
                    "с заданной темой");
            System.out.println("5. Направить письмо заданного человека с заданной темой всем адресатам");
            System.out.println("0. Выйти");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(dbUtils.getMinLetterLength());
                    break;
                case 2:
                    String s;

                    s = dbUtils.getUserInformation();

                        System.out.println(s);

                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите тему: ");
                    String topic = scanner.nextLine();
                    String[] p;
                    p = dbUtils.getUserWithGivenLetterTopic(topic);
                    int i = 0;
                    while (p[i]!=null) {
                        System.out.println(p[i].toString());
                        i++;
                    }
                    break;
                case 4:
                    System.out.println("Введите тему: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String topic1 = scanner1.nextLine();
                    String[] p1;
                    p1 = dbUtils.getUserWithNotGivenLetterTopic(topic1);
                    int j = 0;
                    while (p1[j]!=null) {
                        System.out.println(p1[j].toString());
                        j++;
                    }
                    break;
                case 5:
                    System.out.println("Введите человека: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String pers = scanner2.nextLine();
                    System.out.println("Введите тему: ");
                    String topic2 = scanner2.nextLine();
                    dbUtils.SendLetterToAll(pers, topic2);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
            System.out.println("----------");
        }
        dbUtils.closeConnection();
        in.close();
    }
}