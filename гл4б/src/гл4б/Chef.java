package гл4б;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chef implements Serializable {

    public Salad salad; // salad that he cooks



    public Chef() {

        salad = new Salad();
    }





    public Chef( Salad salad) {

        this.salad = salad;
    }









    public void showIngredientsForCalories(Scanner scanner) {
        double lowerCalories, upperCalories;
        System.out.println("Enter the lower limit:");
            lowerCalories = scanner.nextDouble();
        System.out.println("Enter the upper limit:");
            upperCalories = scanner.nextDouble();
        salad.showIngredientsByCalories(lowerCalories, upperCalories);
    }


    public void showOptions() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        Vegetable vegetable = null;


        System.out.println("What do you want to cook today?");

        while (choice != 0) {
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Rename salad");
            System.out.println("2. Show recipe");
            System.out.println("3. Sort ingredients by calories");
            System.out.println("4. Get ingredients for calories");
            System.out.println("5. Synchronized writing recipe into file");
            System.out.println("0. Exit");

choice = scanner.nextInt();

            switch(choice) {
                case 1:

                    try{ Scanner in = new Scanner(new File("input.txt")) ;
                        try{
                        salad.setname(in.next());} catch (Salad.NameLogicException e) {
                            System.out.println("name is incorrect");
                        }
                    } catch (FileNotFoundException e) {
                    System.out.println("Cannot open the file input.txt");
                }


                    break;

                case 2:
                    salad.showRecipe();

                    break;

                case 3:
                    salad.sortIngredient_sByCalories();
                    break;

                case 4:
                    showIngredientsForCalories(scanner);
                    break;

                case 5:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Input file name: ");
                    String filename = scanner1.next();
                    salad.writeRecipeIntoFile(filename);

                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }
}
