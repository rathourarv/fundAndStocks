package org.fabric.commands;

import org.fabric.models.Portfolio;

import java.util.List;

public class CurrentPortfolioCommand implements Command {

    private final Portfolio portfolio;

    public CurrentPortfolioCommand(Portfolio portFolio) {
        this.portfolio = portFolio;
    }

    @Override
    public void execute(List<String> parameters) {
        this.portfolio.setFunds(parameters);
    }
}
