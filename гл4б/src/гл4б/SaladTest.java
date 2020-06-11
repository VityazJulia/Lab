package гл4б;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SaladTest {

    @Test
    public void testCountCalories() {
        Salad salad = new Salad();
        double actual = salad.countCalories();
        double expected = 195;
        Assert.assertEquals(actual, expected, 0.001);
    }
}