package com.leetcode.array;
/*
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*
 */

class ShellAndBuyStock2
{
	public static int maxProfit(int[] prices) {

		return maxProfit_(prices , 0 , Integer.MAX_VALUE);
	}
	public static int maxProfit_(int prices[] , int i , int minStockPrice){
		if(i == prices.length){
			return 0;
		}

		int min = Math.min(minStockPrice , prices[i]);

		int profit = maxProfit_(prices , i+1 , min );

		profit = Math.max(profit , prices[i] - minStockPrice);
		return profit;


	}


public static void main(String[] args) 
{ 
	int price[] = {10, 9, 8, 9, 10, 11, 9, 10}; 
	int n = price.length; 

	System.out.print(maxProfit(price));
} 
} 
