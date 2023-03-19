package hillel.polezhaiev;

import hillel.polezhaiev.SimpleMathLibrary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.console.ConsoleLauncher;

public class SimpleMathLibraryTest {
    private SimpleMathLibrary mathLibrary;

    @BeforeEach
    public void set(){
        mathLibrary = new SimpleMathLibrary();
    }

    @Test
    public void addTest(){
        double a = 5;
        double b = 6;

        double expected = 11;
        double actual = mathLibrary.add(a, b);
        assert expected == actual;

        if(expected == actual){
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }

        assert expected == actual;
    }

    @Test
    public void minusTest(){
        double a = 5;
        double b = 6;

        double expected = -1;
        double actual = mathLibrary.minus(a, b);

        if(expected == actual){
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }

        assert expected == actual;
    }

    @AfterEach
    public void delete(){
        mathLibrary = null;
    }
}
