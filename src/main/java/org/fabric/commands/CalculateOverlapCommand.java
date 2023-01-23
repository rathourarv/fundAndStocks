package org.fabric.commands;

import org.fabric.models.Fund;
import org.fabric.models.Portfolio;
import org.fabric.printer.Printer;
import org.fabric.services.FundManager;
import org.fabric.services.OverlapCalculator;

import java.util.List;

public class CalculateOverlapCommand implements Command {
    private final Portfolio portfolio;
    private final FundManager fundManager;
    private final Printer printer;

    public CalculateOverlapCommand(FundManager fundManager, Portfolio portFolio, Printer printer) {
        this.fundManager = fundManager;
        this.portfolio = portFolio;
        this.printer = printer;
    }

    @Override
    public void execute(List<String> parameters) {
        Fund fundToCompareWith = fundManager.getFund(parameters.get(0));
        if (fundToCompareWith == null) {
            this.printer.print("FUND_NOT_FOUND");
            return;
        }
        this.portfolio.getFunds().forEach(fundName -> {
            Fund fund = fundManager.getFund(fundName);
            float overlap = OverlapCalculator.calculate(fund, fundToCompareWith);
            if (overlap > 0.0) {
                this.printer.print(
                        String.format("%s %s %.2f%%", fundToCompareWith.name, fund.name, overlap));
            }
        });
    }
}
