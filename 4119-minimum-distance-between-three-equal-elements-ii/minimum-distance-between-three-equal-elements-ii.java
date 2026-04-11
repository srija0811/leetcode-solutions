class Solution {
    public int minimumDistance(int[] nums) {
       Map<Integer, List<Integer>> map = new HashMap<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        } 

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            List<Integer> list = map.get(nums[i]);
            if(list != null && list.size() >= 3 ){
                
                for(int j = 1; j < list.size() - 1; j++){
                    int t = Math.abs(list.get(j-1) - list.get(j)) + Math.abs(list.get(j+1) - list.get(j));
                    t *= 2;
                    min = Math.min(min,t);
                }
                map.remove(nums[i]);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}