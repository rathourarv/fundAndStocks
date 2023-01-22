package org.fabric.models;

import java.util.List;

public class PortFolio {
    private List<String> funds;

    public PortFolio(List<String> funds) {
        this.funds = funds;
    }

    public List<String> getFunds() {
        return funds;
    }

    public void setFunds(List<String> funds) {
        this.funds = funds;
    }
}
