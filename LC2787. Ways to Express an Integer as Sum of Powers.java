class Solution {
    static final int MOD = 1_000_000_007;
    static int n, x;
    static long[][] memo;
      public static int numberOfWays(int N, int X) {
        n = N;
        x = X;
        memo = new long[n + 1][n + 1];
        for (long[] row : memo) Arrays.fill(row, -1);
        return (int) countWays(n, 1);
    }

     private static long countWays(int remaining, int current) {
        if (remaining == 0) return 1; // Found a valid combination
        if (remaining < 0 || current > n) return 0; // Invalid path
        if (memo[remaining][current] != -1) return memo[remaining][current];

        long res = 0;

        // Option 1: Skip current number
        res = (res + countWays(remaining, current + 1)) % MOD;

        // Option 2: Include current number if possible
        long val = (long) Math.pow(current, x);
        if (val <= remaining) {
            res = (res + countWays(remaining - (int) val, current + 1)) % MOD;
        }

        memo[remaining][current] = res;
        return res;
    
    
}


}
