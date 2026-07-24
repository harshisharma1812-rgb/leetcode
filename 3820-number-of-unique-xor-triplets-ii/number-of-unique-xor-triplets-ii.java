class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] present = new boolean[MAX];
        for (int x : nums) {
            present[x] = true;
        }

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        // Since repetition is allowed, relax 3 times
        for (int t = 0; t < 3; t++) {
            boolean[][] next = new boolean[4][MAX];
            for (int k = 0; k <= 3; k++) {
                System.arraycopy(dp[k], 0, next[k], 0, MAX);
            }

            for (int k = 0; k < 3; k++) {
                for (int mask = 0; mask < MAX; mask++) {
                    if (!dp[k][mask]) continue;

                    for (int v = 0; v < MAX; v++) {
                        if (present[v]) {
                            next[k + 1][mask ^ v] = true;
                        }
                    }
                }
            }
            dp = next;
        }

        int ans = 0;
        for (boolean b : dp[3]) {
            if (b) ans++;
        }

        return ans;
    }
}
