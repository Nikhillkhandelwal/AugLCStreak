class Solution {
    private String sortDigits(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);

        for (int i = 0; i < 31; i++) { // 2^0 to 2^30 (max int)
            int powerOf2 = 1 << i; // 2^i
            if (target.equals(sortDigits(powerOf2))) {
                return true;
            }
        }
        return false;
    }
}
