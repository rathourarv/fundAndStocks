package org.fabric.commands;

import org.fabric.models.PortFolio;

import java.util.List;

public class CurrentPortFolio implements Command {

    private final PortFolio portfolio;

    public CurrentPortFolio(PortFolio portFolio) {
        this.portfolio = portFolio;
    }

    @Override
    public void execute(List<String> parameters) {
        this.portfolio.setFunds(parameters);
    }
}
