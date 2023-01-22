package org.fabric.services;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.fabric.models.Fund;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundManager {
    private final Map<String, Fund> funds;

    @JsonCreator
    public FundManager(@JsonProperty("funds") List<Fund> funds) {
        this.funds = new HashMap<>();
        funds.forEach(fund -> this.funds.put(fund.name, fund));
    }

    public Fund getFund(String name) {
        return this.funds.get(name);
    }

}
