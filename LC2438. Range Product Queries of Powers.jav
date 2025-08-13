class Solution {
    static final int MOD = 1_000_000_007;
    public long[] binary(int n){

    List<Long> powersList = new ArrayList<>();
        int power = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powersList.add(1L << power); // 2^power
            }
            n >>= 1;
            power++;
        }
        long[] powers = new long[powersList.size()];
        for (int i = 0; i < powersList.size(); i++) {
            powers[i] = powersList.get(i);
        }
        return powers;
    }
    public int[] productQueries(int n, int[][] queries) {
        long[] bin = binary(n);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long product = 1;
            while (left <= right) {
                product = (product * bin[left]) % MOD;
                left++;
            }
            ans[i] = (int) product;
        }
        return ans;
    }
}
