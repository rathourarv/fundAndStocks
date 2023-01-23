package org.fabric.commands;

import org.fabric.models.Portfolio;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandExecutor {
    private final Map<String, Command> commands;
    private final Printer printer;

    public CommandExecutor(FundManager fundManager, Portfolio portfolio, Printer printer) {
        this.printer = printer;
        this.commands = new HashMap<String, Command>() {
            {
                put("CURRENT_PORTFOLIO", new CurrentPortfolioCommand(portfolio));
                put("ADD_STOCK", new AddStockCommand(fundManager, printer));
                put("CALCULATE_OVERLAP", new CalculateOverlapCommand(fundManager, portfolio, printer));
            }
        };
    }

    public void execute(String line) {
        List<String> commandWithParameters = Arrays.asList(line.split(" "));
        String name = commandWithParameters.get(0);
        List<String> parameters = commandWithParameters.subList(1, commandWithParameters.size());
        Command command = this.commands.get(name);
        if (command == null) {
            this.printer.print("COMMAND_NOT_FOUND");
            return;
        }
        command.execute(parameters);
    }
}
