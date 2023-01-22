package org.fabric.commands;

import org.fabric.models.PortFolio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CurrentPortFolioTest {

    @Test
    void execute() {
        PortFolio portFolio = new PortFolio(new ArrayList<>());
        Command currentPortFolioCommand = new CurrentPortFolio(portFolio);
        List<String> funds = Arrays.asList("1", "2", "3");
        currentPortFolioCommand.execute(funds);
        assertTrue(portFolio.getFunds().size() == funds.size() && portFolio.getFunds().containsAll(funds) && funds.containsAll(portFolio.getFunds()));
    }
}