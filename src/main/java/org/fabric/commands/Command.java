package org.fabric.commands;

import org.fabric.models.Portfolio;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;

import java.util.List;

public abstract class Command {
    protected final Portfolio portfolio;
    protected final FundManager fundManager;
    protected final Printer printer;

    public Command(FundManager fundManager, Portfolio portfolio, Printer printer) {
        this.fundManager = fundManager;
        this.portfolio = portfolio;
        this.printer = printer;
    }

    public abstract void execute(List<String> parameters);
}
