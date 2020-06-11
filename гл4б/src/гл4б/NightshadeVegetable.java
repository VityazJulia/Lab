package гл4б;

import java.io.Serializable;

public class NightshadeVegetable extends Vegetable implements Serializable {

    public NightshadeVegetable(String name, double calories) {
        super(name, calories);
        setCategory("Nightshade vegetables");
    }

    public NightshadeVegetable(String name, double calories, double weight) {
        super(name, calories, weight);
        setCategory("Nightshade vegetables");
    }
}
