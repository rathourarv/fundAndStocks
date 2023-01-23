package org.fabric.commands;

import org.fabric.models.Fund;
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


class AddStockCommandTest {
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
        Fund fund = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        FundManager fundManager = new FundManager(Collections.singletonList(fund));
        Command command = new AddStockCommand(fundManager, new ConsolePrinter());
        command.execute(Arrays.asList("FUND_1", "HDFC"));
        assertEquals(fund.getNumberOfStocks(), 4);
    }

    @Test
    void execute_should_log_fund_not_found_when_fund_name_is_not_present() {
        FundManager fundManager = new FundManager(new ArrayList<>());
        Command command = new AddStockCommand(fundManager, new ConsolePrinter());
        command.execute(Arrays.asList("FUND_1", "HDFC"));
        assertEquals("FUND_NOT_FOUND", outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_should_not_fail_when_stock_name_has_space() {
        Fund fund = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        FundManager fundManager = new FundManager(Collections.singletonList(fund));
        Command command = new AddStockCommand(fundManager, new ConsolePrinter());
        command.execute(Arrays.asList("FUND_1", "KARNATAKA", "BANK"));
        assertEquals(fund.getNumberOfStocks(), 4);
    }
}