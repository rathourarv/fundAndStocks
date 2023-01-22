package org.fabric.services;

import org.fabric.models.Fund;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class OverlapCalculatorTest {

    @Test
    void calculate() {
        Fund fund1 = new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        Fund fund2 = new Fund("FUND_2", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")));
        Fund fund3 = new Fund("FUND_3", new HashSet<>(Collections.singletonList("YES BANK")));
        assert new OverlapCalculator().calculate(fund1, fund2) == 100;
        assert new OverlapCalculator().calculate(fund1, fund3) == 0;
    }
}