package org.fabric;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void main() throws FileNotFoundException {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.main(new String[]{"src/test/resources/input.txt"});
        assertEquals(
                "ICICI_PRU_NIFTY_NEXT_50_INDEX UTI_NIFTY_INDEX 20.37%\n" +
                        "ICICI_PRU_NIFTY_NEXT_50_INDEX AXIS_MIDCAP 14.81%\n" +
                        "ICICI_PRU_NIFTY_NEXT_50_INDEX PARAG_PARIKH_FLEXI_CAP 7.41%\n" +
                        "FUND_NOT_FOUND\n" +
                        "ICICI_PRU_NIFTY_NEXT_50_INDEX UTI_NIFTY_INDEX 20.37%\n" +
                        "ICICI_PRU_NIFTY_NEXT_50_INDEX AXIS_MIDCAP 14.68%\n" +
                        "ICICI_PRU_NIFTY_NEXT_50_INDEX PARAG_PARIKH_FLEXI_CAP 7.32%", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }

    @Test
    void mainShouldThrowFileNotException() {
        assertThrows(FileNotFoundException.class, () -> Main.main(new String[]{"src/test/resources/command.txt"}));
    }
}