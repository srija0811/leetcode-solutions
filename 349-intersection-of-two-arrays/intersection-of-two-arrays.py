class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
       hm={}
       result=[]
       for num in nums1:
        hm[num]=1
       for num in nums2:
        if num in nums1 and num not in result:
            result.append(num)
       return result 