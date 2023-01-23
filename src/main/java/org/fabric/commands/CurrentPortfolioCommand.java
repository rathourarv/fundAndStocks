package org.fabric.commands;

import org.fabric.models.Portfolio;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.util.List;

public class CurrentPortfolioCommand extends Command {
    public CurrentPortfolioCommand(FundManager fundManager, Portfolio portfolio, Printer printer) {
        super(fundManager, portfolio, printer);
    }

    @Override
    public void execute(List<String> parameters) {
        this.portfolio.setFunds(parameters);
    }
}
