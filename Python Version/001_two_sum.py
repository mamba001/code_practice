from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i, num in enumerate(nums):
            if target - num in hashmap:
                return [hashmap[target - num], i]
            hashmap[num] = i


s = Solution()
print(s.twoSum([2, 7, 11, 15], 9))

#time O(n)
#space O(n)