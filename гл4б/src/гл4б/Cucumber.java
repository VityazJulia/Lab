package гл4б;

import java.io.Serializable;

public class Cucumber extends CucurbitaceaeVegetable implements Serializable {
    public Cucumber() {
        super("Cucumber", 16);
    }

    public Cucumber(double weight) {
        super("Cucumber", 16, weight);
    }
}
