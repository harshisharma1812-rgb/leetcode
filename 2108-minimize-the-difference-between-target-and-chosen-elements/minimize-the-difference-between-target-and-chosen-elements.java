class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {

        int rows = mat.length;

        int maxSum = 0;
        for (int[] row : mat) {
            int max = 0;
            for (int val : row) {
                max = Math.max(max, val);
            }
            maxSum += max;
        }

        boolean[] dp = new boolean[maxSum + 1];
        dp[0] = true;

        int currentMax = 0;

        for (int[] row : mat) {

            boolean[] next = new boolean[maxSum + 1];

            for (int sum = 0; sum <= currentMax; sum++) {

                if (!dp[sum]) continue;

                for (int num : row) {
                    next[sum + num] = true;
                }
            }

            dp = next;

            currentMax += 70;
            if (currentMax > maxSum)
                currentMax = maxSum;
        }

        int ans = Integer.MAX_VALUE;

        for (int sum = 0; sum <= maxSum; sum++) {
            if (dp[sum]) {
                ans = Math.min(ans, Math.abs(sum - target));
            }
        }

        return ans;
    }
}
