class Solution {
    private int dist(int a, int b) {
        if (a == 26 || b == 26) 
            return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }

    public int minimumDistance(String word) {
        int[] dp = new int[27];
        Arrays.fill(dp, 1000000);
        dp[26] = 0;
        int prev = word.charAt(0) - 'A';

        for (int i = 1; i < word.length(); i++) {
            int cur = word.charAt(i) - 'A';
            int[] next_dp = new int[27];
            Arrays.fill(next_dp, 1000000);
            for (int free = 0; free < 27; free++) {
                if (dp[free] >= 1000000) 
                    continue;
                next_dp[free] = Math.min(next_dp[free], dp[free] + dist(prev, cur));
                next_dp[prev] = Math.min(next_dp[prev], dp[free] + dist(free, cur));
            }
            dp = next_dp;
            prev = cur;
        }

        int res = 1000000;
        for (int v : dp) 
            res = Math.min(res, v);
        return res;
    }
}