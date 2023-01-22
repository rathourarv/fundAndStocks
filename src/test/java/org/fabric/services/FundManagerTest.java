package org.fabric.services;

import org.fabric.models.Fund;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class FundManagerTest {
    @Test
    void GetFund() {
        FundManager fundManager = new FundManager(
                Collections.singletonList(new Fund("FUND_1", new HashSet<>(Arrays.asList("HDFC BANK", "SBI", "RBL BANK")))));
        assert fundManager.getFund("FUND_1") != null;
    }
}