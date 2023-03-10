package org.fabric.commands;

import org.fabric.models.Fund;
import org.fabric.models.Portfolio;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.util.List;

public class AddStockCommand extends Command {
    public AddStockCommand(FundManager fundManager, Portfolio portfolio, Printer printer) {
        super(fundManager, portfolio, printer);
    }

    @Override
    public void execute(List<String> parameters) {
        Fund fund = this.fundManager.getFund(parameters.get(0));
        if (fund == null) {
            this.printer.print("FUND_NOT_FOUND");
            return;
        }
        fund.addStock(String.join(" ", parameters.subList(1, parameters.size())));
    }
}
