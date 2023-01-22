package org.fabric.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class Fund {
    public final String name;
    private final Set<String> stocks;

    @JsonCreator
    public Fund(@JsonProperty("name") String name, @JsonProperty("stocks") HashSet<String> stocks) {
        this.name = name;
        this.stocks = stocks;
    }

    public void addStock(String stock) {
        stocks.add(stock);
    }

    public int getNumberOfStocks() {
        return this.stocks.size();
    }

    public Set<String> getOverlappingStocks(Fund fund) {
        HashSet<String> intersection = new HashSet<>(this.stocks);
        intersection.retainAll(fund.stocks);
        return intersection;
    }
}
