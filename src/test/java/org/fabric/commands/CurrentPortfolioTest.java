package org.fabric.commands;

import org.fabric.models.Portfolio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CurrentPortfolioTest {

    @Test
    void execute() {
        Portfolio portFolio = new Portfolio(new ArrayList<>());
        Command currentPortfolioCommand = new CurrentPortfolioCommand(portFolio);
        List<String> funds = Arrays.asList("1", "2", "3");
        currentPortfolioCommand.execute(funds);
        assertTrue(portFolio.getFunds().size() == funds.size() && portFolio.getFunds().containsAll(funds) && funds.containsAll(portFolio.getFunds()));
    }
}