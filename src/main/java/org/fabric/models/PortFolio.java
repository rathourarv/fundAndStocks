package org.fabric.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PortFolio {
    private List<String> funds;

    public PortFolio(List<String> funds) {
        this.funds = funds;
    }

}
