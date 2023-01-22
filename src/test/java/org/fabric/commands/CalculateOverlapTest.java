package org.fabric.commands;

import org.fabric.models.Fund;
import org.fabric.models.PortFolio;
import org.fabric.printer.ConsolePrinter;
import org.fabric.services.FundManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateOverlapTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void execute() {
        Fund fund1 = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        Fund fund2 = new Fund("FUND_2", new HashSet<>(Arrays.asList("HDFC BANK", "PNB", "CHASE")));
        FundManager fundManager = new FundManager(Arrays.asList(fund1, fund2));
        PortFolio portFolio = new PortFolio((Arrays.asList("FUND_1", "FUND_2")));
        Command command = new CalculateOverlap(fundManager, portFolio, new ConsolePrinter());
        command.execute(Collections.singletonList("FUND_1"));
        assertEquals("FUND_1 FUND_1 100.00%\n" +
                "FUND_1 FUND_2 33.33%", outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_should_log_fund_not_found_when_fund_name_is_not_present() {
        Fund fund = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        FundManager fundManager = new FundManager(Collections.singletonList(fund));
        PortFolio portFolio = new PortFolio(new ArrayList<>(Collections.singletonList("FUND_1")));
        Command command = new CalculateOverlap(fundManager, portFolio, new ConsolePrinter());
        command.execute(Collections.singletonList("FUND_2"));
        assertEquals("FUND_NOT_FOUND", outputStreamCaptor.toString().trim());
    }
}