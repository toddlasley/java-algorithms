package xyz.toddlasley.leetcode.easy.arraysandstrings;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProfitTest {
    @Test
    public void findMaxProfitReturnsProfit() {
        assertEquals(1, MaxProfit.findMaxProfit(Lists.newArrayList(1, 2)));
        assertEquals(2, MaxProfit.findMaxProfit(Lists.newArrayList(1, 2, 3)));
        assertEquals(6, MaxProfit.findMaxProfit(Lists.newArrayList(2, 4, 5, 1, 2, 7)));
        assertEquals(5, MaxProfit.findMaxProfit(Lists.newArrayList(2, 4, 5, 3, 4, 7)));
        assertEquals(0, MaxProfit.findMaxProfit(Lists.newArrayList(2, 1)));
        assertEquals(0, MaxProfit.findMaxProfit(Lists.newArrayList(2, 2)));
        assertEquals(0, MaxProfit.findMaxProfit(Lists.newArrayList(4, 3, 2, 1)));
    }
}