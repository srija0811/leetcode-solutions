class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length, ans = Integer.MIN_VALUE;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        while(r < n) {
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);

            if(mpp.get(nums[r]) <= k) {
                ans = Math.max(ans, r - l + 1);
            }

            if(mpp.get(nums[r]) > k) {
                while(mpp.get(nums[r]) > k) {
                    mpp.put(nums[l], mpp.get(nums[l]) - 1);

                    if(mpp.get(nums[l]) == 0) {
                        mpp.remove(nums[l]);
                    }

                    l++;
                }
            }

            r++;
        }

        return ans;
    }
}