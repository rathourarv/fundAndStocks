package org.fabric.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PortFolioTest {

    @Test
    void getFunds() {
        List<String> funds = new ArrayList<>();
        PortFolio portFolio = new PortFolio(funds);
        assert portFolio.getFunds() == funds;
    }

    @Test
    void setFunds() {
        PortFolio portFolio = new PortFolio(new ArrayList<>());
        List<String> funds = Arrays.asList("1", "2");
        portFolio.setFunds(funds);
        assert portFolio.getFunds() == funds;
    }
}