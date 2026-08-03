class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        hm={}
        for num in nums:
            hm[num]=1
        for i in range(len(nums)+1):
            if i not in hm:
                return i
        