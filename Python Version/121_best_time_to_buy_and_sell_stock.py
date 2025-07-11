from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minBuy = prices[0]
        res = 0
        for p in prices:
            minBuy = min(minBuy, p)
            res = max(res, p - minBuy)
        return res
        