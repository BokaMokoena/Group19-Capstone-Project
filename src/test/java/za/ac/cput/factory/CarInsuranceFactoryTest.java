package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CarInsurance;
import static org.junit.jupiter.api.Assertions.*;

public class CarInsuranceFactoryTest {


    @Test
    void buildCarInsurance() {
        CarInsurance carInsurance = CarInsuranceFactory.buildCarInsurance(
                "MiWay", 15447841, "Insurance", 1200
        );
        assertNotNull(carInsurance);
        System.out.println(carInsurance);
    }
    @Test
    void testBuildCarInsuranceWithFail() {
        CarInsurance carInsurance = CarInsuranceFactory.buildCarInsurance(
                "MiWay", 15447841, "", 1200
        );
        assertNull(carInsurance);
        System.out.println(carInsurance);
    }
}
