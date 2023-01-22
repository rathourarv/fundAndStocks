package org.fabric.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

class FundTest {
    @Test
    void addStock() {
        Fund fund = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        fund.addStock("YES BANK");
        assert fund.getNumberOfStocks() == 4;
    }

    @Test
    void getNumberOfStocks() {
        Fund fund = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        assert fund.getNumberOfStocks() == 3;
    }

    @Test
    void getOverlappingStocks() {
        Fund fund1 = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        Fund fund2 = new Fund("FUND_2", new HashSet<>(Arrays.asList("HDFC BANK", "RBL BANK")));
        assert Objects.equals(fund1.getOverlappingStocks(fund2), new HashSet<>(Arrays.asList("HDFC BANK", "RBL BANK")));
    }
}