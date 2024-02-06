// You are given an array prices where prices[i] is the price of a given
// stock on the ith day.
// Return the maximum profit you can achieve from this transaction.
// If you cannot achieve any profit, return 0.

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package xyz.toddlasley.leetcode.easy.arraysandstrings;

import java.util.List;

public class MaxProfit {
    public static int findMaxProfit(final List<Integer> prices) {
        int maxProfit = 0;
        int i = 0;

        for (int j = 1; j < prices.size(); j++) {
            int currentProfit = prices.get(j) - prices.get(i);

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            if (prices.get(j) < prices.get(i)) {
                i = j;
            }
        }

        return maxProfit;
    }
}
