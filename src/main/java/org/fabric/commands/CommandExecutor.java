package org.fabric.commands;

import org.fabric.models.PortFolio;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandExecutor {
    private final Map<String, Command> commands;
    private final Printer printer;

    public CommandExecutor(FundManager fundManager, PortFolio portfolio, Printer printer) {
        this.printer = printer;
        this.commands = new HashMap<String, Command>() {
            {
                put("CURRENT_PORTFOLIO", new CurrentPortFolio(portfolio));
                put("ADD_STOCK", new AddStock(fundManager, printer));
                put("CALCULATE_OVERLAP", new CalculateOverlap(fundManager, portfolio, printer));
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
