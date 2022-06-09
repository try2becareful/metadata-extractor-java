package test.java.fileTypeAnalyzerTest;

import main.java.com.fileTypeAnalyzer.detectType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class detectTypeTest {

    @Test
    void computePrefix() {
        detectType detect = new detectType();
        byte[] values = new byte[5];
        //byte[] values = new byte[5]{123, 92, 114, 116, 102};

        // Assigning elements
        values[0] = 123;
        values[1] = 92;
        values[2] = 114;
        values[3] = 116;
        values[4] = 102;

        int[] prefix = detect.computePrefix(values);
        int[] trueResult = {0, 0, 0, 0, 0};
        assertEquals(Arrays.toString(trueResult), Arrays.toString(prefix));


    }
}