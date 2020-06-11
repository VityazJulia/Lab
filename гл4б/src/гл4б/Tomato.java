package гл4б;

import java.io.Serializable;

public class Tomato extends NightshadeVegetable  implements Serializable {
    public Tomato() {
        super("Tomato", 18);
    }



    public Tomato(double weight) {
        super("Tomato", 18, weight);
    }
}
