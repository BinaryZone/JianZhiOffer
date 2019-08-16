package com.wh;

public class Offer63 {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
			return 0;
		}
        int min = prices[0];
        int maxPro = 0;
        for(int i = 1;i < prices.length;i++) {
        	if (prices[i] - min > maxPro) {
				maxPro = prices[i] - min;
			}
        	if (prices[i] < min) {
				min = prices[i];
			}
        }
        return maxPro;
    }
}
