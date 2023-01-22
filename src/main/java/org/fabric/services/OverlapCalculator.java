package org.fabric.services;

import org.fabric.models.Fund;

import java.util.Set;

public class OverlapCalculator {
    public static float calculate(Fund fund1, Fund fund2) {
        Set<String> commonStocks = fund1.getOverlappingStocks(fund2);
        return 2 * (commonStocks.size() / (float) (fund1.getNumberOfStocks() + fund2.getNumberOfStocks())) * 100;
    }
}
