package hillel.polezhaiev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class TestRunner {
    private ArrayLibrary arrayLibrary;

    @BeforeEach
    public void set(){
        arrayLibrary = new ArrayLibrary();
    }

    @Test
    public void getAfterLast4_test_success(){
        int [] actual = arrayLibrary.getArrAfterLast4(new int[]{3, 5, 7, 4, 0, 4, 9, 7, 2});
        int [] expected = new int[] {9, 7, 2};
    }

    @Test
    public void getAfterLast4_test(){
        int [] actual = arrayLibrary.getArrAfterLast4(new int[]{4, 5, 7, 7, 0, 3, 9, 7, 2});
        int [] expected = new int[] {5, 7, 7, 0, 3, 9, 7, 2};
    }

    @Test
    public void getAfterLast4_test_without4(){
        assertThrows(RuntimeException.class, () ->{
            arrayLibrary.getArrAfterLast4(new int[] {5, 7, 7, 0, 3, 9, 7, 2});
        });

    }

    @Test
    public void checkFor_1_and_4_test_success(){
        boolean actual = arrayLibrary.checkFor_1_and_4(new int[]{4, 5, 7, 7, 0, 1});
        boolean expected = true;

        assert actual == expected;
    }

    @Test
    public void checkFor_1_and_4_test_w1(){
        boolean actual = arrayLibrary.checkFor_1_and_4(new int[]{4, 5, 7, 7, 0});
        boolean expected = true;

        assert actual == expected;
    }

    @Test
    public void checkFor_1_and_4_test_w4(){
        boolean actual = arrayLibrary.checkFor_1_and_4(new int[]{5, 7, 7, 0, 1});
        boolean expected = true;

        assert actual == expected;
    }

    @AfterEach
    public void finish(){
        arrayLibrary = null;
    }

}
