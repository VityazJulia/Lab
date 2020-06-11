package гл4б;

import java.io.Serializable;

public class Dill extends SpicyVegetable implements Serializable {
    public Dill() {
        super("Dill", 43);
    }


    public Dill(double weight) {
        super("Dill", 43, weight);
    }
}
