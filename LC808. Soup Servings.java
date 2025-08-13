class Solution {
   public double soupServings(int n) {
        if (n > 5000) return 1.0; // For large n, probability approaches 1
        // int m = (int) Math.ceil(n / 25.0);
        double[][] dp = new double[n + 1][n+ 1];
        for (double[] arr : dp) Arrays.fill(arr, -1.0);
        return dfs(n, n, dp);
    }

    private double dfs(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5; // both empty same time
        if (a <= 0) return 1.0;           // A empty first
        if (b <= 0) return 0.0;           // B empty first

        if (dp[a][b] != -1.0) return dp[a][b];

        dp[a][b] = 0.25 * (
            dfs(a - 100, b, dp) +
            dfs(a - 75, b - 25, dp) +
            dfs(a - 50, b - 50, dp) +
            dfs(a - 25, b - 75, dp)
        );

        return dp[a][b];
    }
}
