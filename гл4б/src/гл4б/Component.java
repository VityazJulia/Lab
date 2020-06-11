package гл4б;

import java.io.Serializable;

public class Component implements Serializable {
    private final Vegetable ingredient;
    private double amount;

    //Creating new Component with a certain amount of Vegetable
    public Component(Vegetable veggie, double amount) {
        this.ingredient = veggie;
        if(amount < 0) {
            throw new IllegalArgumentException("Amount must be nonnegative");
        }
        this.amount = amount;
    }

    //If amount not given, just set it to zero
    public Component(Vegetable veggie) {
        this.ingredient = veggie;
        this.amount = 0;
    }


    public double getAmount() {
        return this.amount;
    }


    public Vegetable getIngredient() {
        return this.ingredient;
    }


    public void addAmount(double amt) {
        if(amt < 0) {
            throw new IllegalArgumentException("Amount must be nonnegative");
        }
        this.amount += amt;
    }


    public void use(double amt) {
        if(amt < 0) {
            throw new IllegalArgumentException("Amount must be nonnegative");
        }
        else if(this.amount - amt >= 0) {
            this.amount -= amt;
        }
        else {
            throw new ArithmeticException("Not enough " + this.getIngredient());
        }
    }



}
