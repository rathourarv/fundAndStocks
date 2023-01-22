package org.fabric.commands;

import org.fabric.models.Fund;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.util.List;

public class AddStock implements Command {
    private final FundManager fundManager;
    private final Printer printer;

    public AddStock(FundManager fundManager, Printer printer) {
        this.fundManager = fundManager;
        this.printer = printer;
    }

    @Override
    public void execute(List<String> parameters) {
        Fund fund = this.fundManager.getFund(parameters.get(0));
        if (fund == null) {
            this.printer.print("FUND_NOT_FOUND");
            return;
        }
        fund.addStock(String.join(" "));
    }
}
