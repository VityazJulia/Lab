package гл4б;

import java.io.Serializable;

public class SpicyVegetable extends Vegetable implements Serializable {



    public SpicyVegetable(String name, double calories) {
        super(name, calories);
        setCategory("Spicy vegetables");
    }

    public SpicyVegetable(String name, double calories, double weight) {
        super(name, calories, weight);
        setCategory("Spicy vegetables");
    }
}
