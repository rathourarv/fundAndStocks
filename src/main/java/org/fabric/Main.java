package org.fabric;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fabric.commands.CommandOrchestrator;
import org.fabric.models.Portfolio;
import org.fabric.printer.ConsolePrinter;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Path inputFilePath = Paths.get(args[0]);
        try {
            List<String> lines = Files.readAllLines(inputFilePath);
            FundManager fundManager = getFundManager("stock_data.json");
            Printer printer = new ConsolePrinter();
            Portfolio portfolio = new Portfolio(new ArrayList<>());
            CommandOrchestrator commandOrchestrator = new CommandOrchestrator(fundManager, portfolio, printer);
            lines.forEach(commandOrchestrator::execute);
        } catch (IOException ex) {
            throw new FileNotFoundException("FILE_NOT_FOUND");
        }
    }

    public static FundManager getFundManager(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream(filename), FundManager.class);
    }
}