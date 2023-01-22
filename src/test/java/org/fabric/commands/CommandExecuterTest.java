package org.fabric.commands;

import org.fabric.models.Fund;
import org.fabric.models.PortFolio;
import org.fabric.printer.ConsolePrinter;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class CommandExecutorTest {
    @Test
    void executeShouldReturnAddStockCommandInstance() {
        Fund fund = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        FundManager fundManager = new FundManager(
                Collections.singletonList(fund)
        );
        PortFolio portFolio = new PortFolio(new ArrayList<>());
        Printer printer = new ConsolePrinter();

        CommandExecutor commandExecutor = new CommandExecutor(fundManager, portFolio, printer);
        commandExecutor.execute("ADD_STOCK FUND_1 PNB");
        Assertions.assertEquals(4, fund.getNumberOfStocks());
    }

    @Test
    void executeShouldPrintCommandNotFound() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        FundManager fundManager = new FundManager(new ArrayList<>());
        PortFolio portFolio = new PortFolio(new ArrayList<>());
        Printer printer = new ConsolePrinter();
        CommandExecutor commandExecutor = new CommandExecutor(fundManager, portFolio, printer);
        commandExecutor.execute("UNKNOWN");
        Assertions.assertEquals("COMMAND_NOT_FOUND", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }

}
