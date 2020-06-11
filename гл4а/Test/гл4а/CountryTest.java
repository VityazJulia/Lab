package гл4а;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CountryTest {

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void testCalculateSquare() throws District.SquareLogicException {
        Country country = new Country();
        City capital = new City ("");
        Region[] regions = new Region[5];
        for(int i=0; i<2; i++) {

            District[] districts = new District[5];
            districts[0] = new District ("", capital, 10000);
            districts[1]= new District ("", capital, 20000);
            districts[2]= new District ("", capital, 30000);
            City capitali = new City("");
            regions[i] = new Region("", capitali, 3, districts);

        }
        country = new Country("", capital, 2, regions);
        double actual = country.CalculateSquare();
        double expected = 120000;
        Assert.assertEquals(actual, expected, 0.001);
    }
}