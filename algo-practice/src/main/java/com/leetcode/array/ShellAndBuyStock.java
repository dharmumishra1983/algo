package com.leetcode.array;// Java implementation of the approach
// We need to come up with an API which provides max profit to end investor for a specific company
// Assume that you have a prediction algorithm in the background which gives you all the stock values in
// future for a given company.
//           1, 2, 3, 4, 5,  6,  7,  8 --> Assume these are days
// For E.g. {10, 9, 8, 9, 10, 11, 9, 10} --> buy at 3rd and sell at 6th and
// again buy at 7th and sell at 8th --> Profit = 3 + 1 = 4

class ShellAndBuyStock
{ 

// Function to return the maximum profit 
// that can be made after buying and 
// selling the given stocks 
public static int maxProfit2NdApproach(int[] prices) {
        int Max = 0;
        for (int i = 0; i < prices.length-1; i++){
            if (prices[i+1] > prices[i]){
                Max += prices[i+1]-prices[i];
            }
        }
        return Max;
    }
static int maxProfit(int price[], int start, int end) 
{ 

	// If the stocks can't be bought 
	if (end <= start) 
		return 0; 

	// Initialise the profit 
	int profit = 0; 

	// The day at which the stock 
	// must be bought 
	for (int i = start; i < end; i++) 
	{ 

		// The day at which the 
		// stock must be sold 
		for (int j = i + 1; j <= end; j++) 
		{ 

			// If byuing the stock at ith day and 
			// selling it at jth day is profitable 
			if (price[j] > price[i]) 
			{ 

				// Update the current profit 
				int curr_profit = price[j] - price[i] 
								+ maxProfit(price, start, i - 1) 
								+ maxProfit(price, j + 1, end); 

				// Update the maximum profit so far 
				profit = Math.max(profit, curr_profit); 
			} 
		} 
	} 
	return profit; 
} 


public static void main(String[] args) 
{ 
	int price[] = {10, 9, 8, 9, 10, 11, 9, 10}; 
	int n = price.length; 

	System.out.print(maxProfit(price, 0, n - 1)); 
} 
} 
