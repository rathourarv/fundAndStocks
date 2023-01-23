package org.fabric.commands;

import org.fabric.models.Portfolio;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandExecutor {
    enum Commands {
        ADD_STOCK,
        CURRENT_PORTFOLIO,
        CALCULATE_OVERLAP
    }

    private final Map<Commands, Command> commands;
    private final Printer printer;

    public CommandExecutor(FundManager fundManager, Portfolio portfolio, Printer printer) {
        this.printer = printer;
        this.commands = new HashMap<Commands, Command>() {
            {
                put(Commands.CURRENT_PORTFOLIO, new CurrentPortfolioCommand(portfolio));
                put(Commands.ADD_STOCK, new AddStockCommand(fundManager, printer));
                put(Commands.CALCULATE_OVERLAP, new CalculateOverlapCommand(fundManager, portfolio, printer));
            }
        };
    }

    public void execute(String line) {
        List<String> commandWithParameters = Arrays.asList(line.split(" "));
        List<String> parameters = commandWithParameters.subList(1, commandWithParameters.size());

        try {
            Command command = this.commands.get(Commands.valueOf(commandWithParameters.get(0)));
            command.execute(parameters);
        } catch (IllegalArgumentException ex) {
            this.printer.print("COMMAND_NOT_FOUND");
        }
    }
}
