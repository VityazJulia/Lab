package гл4б;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad  implements Serializable {
    private String name;
    public BufferedWriter writer1;
    public BufferedWriter writer2;

    public Vegetable[] ingredient_s = new Vegetable[50];


    public class NameLogicException extends Exception {
        public NameLogicException() {
        }
        public NameLogicException(String message, Throwable exception) {
            super(message, exception);
        }
        public NameLogicException(String message) {
            super(message);
        }
        public NameLogicException (Throwable exception) {
            super(exception);
        }
    }


    public Salad() {
        name = "Unknown";
        ingredient_s[0] = new Carrot();
        ingredient_s[1] = new Cucumber();
        ingredient_s[2] = new Dill();
        ingredient_s[3] = new Potato();
        ingredient_s[4] = new Tomato();
    }


    public Salad(String name) {
        this.name = name;
        ingredient_s[0] = new Carrot();
        ingredient_s[1] = new Cucumber();
        ingredient_s[2] = new Dill();
        ingredient_s[3] = new Potato();
        ingredient_s[4] = new Tomato();
    }

    public String getName() {
        return name;
    }



    public Vegetable[] getIngredient_s() {
        return ingredient_s;
    }

    public void setname(String name1) throws NameLogicException {
        if(name1.equalsIgnoreCase("Unknown")) {
            throw new NameLogicException("name is incorrect");
        }


        this.name = name1;
    }



    public synchronized void writeRecipeIntoFile(String filename) throws IOException, InterruptedException {
        this.writer1 = new BufferedWriter(new FileWriter(filename));
        this.writer2 = new BufferedWriter(new FileWriter(filename));
        synchronized(writer1) {
            try {writer1.flush();
                writer1.write("The salad " + name + " contains:"+"\n");
                writer1.wait(1000);
                for(int i=0; i < 5; i++)
                    writer2.write(ingredient_s[i].toString()+"\n");
                writer2.flush();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized(writer2) {
            try {
                writer2.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized(writer1) {
                writer1.notify();
writer1.write("here was smth about carrot)");
writer1.flush();
        }
    }



    public void showRecipe() {


        System.out.println("The salad " + name + " contains:");
        for(int i=0; i < 5; i++)
            System.out.println(ingredient_s[i].toString());

        System.out.println("----------------------------");
        System.out.println("Total energy: " + countCalories() + "kcal");
    }

    public double countCalories() {
        double calories = 0.0;
        for (int i=0; i < 5; i++)
            calories += ingredient_s[i].getTotalCalories();


        return calories;
    }



    public void sortIngredient_sByCalories() {
        Vegetable[] ingredient_ss = new Vegetable[50];

        int[] num = new int[]{0, 1, 2, 3, 4};
    for(int i=0; i < 5; i++)
        for(int j=0; j<5; j++)
        {if (ingredient_s[num[i]].getCalories() < ingredient_s[num[j]].getCalories()) {
                int p = num[i];
                num[i] = num[j];
                num[j] = p;
            }}
        for(int i=0; i < 5; i++)
            ingredient_ss[i] = ingredient_s[num[i]];

        for(int i=0; i < 5; i++)
            System.out.println(ingredient_ss[i].toString());

    }





    public void showIngredientsByCalories(double lowerCalories,
                                          double upperCalories) {
        double calories;

        System.out.println("Ingredients for calories ["
                + lowerCalories + ", " + upperCalories + "]");
        for (int i=0; i < 5; i++) {
            calories = ingredient_s[i].getCalories();
            if (calories >= lowerCalories && calories <= upperCalories) {
                System.out.println(ingredient_s[i].getName() + ", "
                        + ingredient_s[i].getCalories() + "kcal per 100g");
            }
        }
    }
}
