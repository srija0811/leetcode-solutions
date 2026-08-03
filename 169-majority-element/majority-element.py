class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        hm={}
        for num in nums:
            if num in hm:
                hm[num]+=1
            else:
                hm[num]=1
            if hm[num]>len(nums)//2:
                return num
        