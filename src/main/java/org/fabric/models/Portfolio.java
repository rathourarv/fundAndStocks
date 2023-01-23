package org.fabric.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Portfolio {
    private List<String> funds;

    public Portfolio(List<String> funds) {
        this.funds = funds;
    }

}
