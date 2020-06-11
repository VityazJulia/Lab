package гл4б;

import java.io.Serializable;

public class Potato extends NightshadeVegetable implements Serializable {
    public Potato() {
        super("Potato", 77);
    }


    public Potato(double weight) {
        super("Potato", 77, weight);
    }
}
