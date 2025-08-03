class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;

        // -------- LEFT to RIGHT Window --------
        int sum = 0, left = 0;
        for (int right = 0; right < n; right++) {
            int leftPos = fruits[left][0];
            int rightPos = fruits[right][0];

            // Add current right fruit amount
            sum += fruits[right][1];

            // Cost = go to left first, then to right
            int steps = Math.abs(startPos - leftPos) + (rightPos - leftPos);
            while (left <= right && steps > k) {
                sum -= fruits[left][1];
                left++;
                if (left <= right) {
                    leftPos = fruits[left][0];
                    steps = Math.abs(startPos - leftPos) + (rightPos - leftPos);
                }
            }

            maxFruits = Math.max(maxFruits, sum);
        }

        // -------- RIGHT to LEFT Window --------
        int right = n - 1;
        sum = 0;
        for (left = n - 1; left >= 0; left--) {
            int leftPos = fruits[left][0];
            int rightPos = fruits[right][0];

            // Add current left fruit amount
            sum += fruits[left][1];

            // Cost = go to right first, then to left
            int steps = Math.abs(startPos - rightPos) + (rightPos - leftPos);
            while (right >= left && steps > k) {
                sum -= fruits[right][1];
                right--;
                if (right >= left) {
                    rightPos = fruits[right][0];
                    steps = Math.abs(startPos - rightPos) + (rightPos - leftPos);
                }
            }

            maxFruits = Math.max(maxFruits, sum);
        }

        return maxFruits;
    }
}
