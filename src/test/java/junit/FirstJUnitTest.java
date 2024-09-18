package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {
    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
    }
}
