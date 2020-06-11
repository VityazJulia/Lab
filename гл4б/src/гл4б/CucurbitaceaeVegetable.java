package гл4б;

import java.io.Serializable;

public class CucurbitaceaeVegetable extends Vegetable  implements Serializable {

    public CucurbitaceaeVegetable(String name, double calories) {
        super(name, calories);
        setCategory("Cucurbitaceae vegetables");
    }

    public CucurbitaceaeVegetable(String name, double calories, double weight) {
        super(name, calories, weight);
        setCategory("Cucurbitaceae vegetables");
    }
}
