class Solution {
    int N; 
    int mx = 1_00_001; 
    int memo[]; 
    private boolean canWin(int pos) {
        if(pos >= N) return false; // no stones left we loose

        if(memo[pos] != -1) return memo[pos] > 0; 

        for(int i = 1; i * i < mx ; i++) {
            int cur = i * i; 
            if((pos + i * i) > N) {
                break; 
            }

            if(!canWin(pos + cur)) {
                memo[pos] = 1; 
                return true; 
            } 
        }
        memo[pos] = 0; 
        return false;  
    }
    public boolean winnerSquareGame(int n) {
        // Given they move square no of piles 
        // we need to find out from any pos [l, nextSquare] 
        // can do this via binary lifting, we have to precalculate this. 
        this.N = n; 
        memo = new int[n + 1]; 
        Arrays.fill(memo, -1);
        // there is `n` squares only. 
        return canWin(0); 
    }
}