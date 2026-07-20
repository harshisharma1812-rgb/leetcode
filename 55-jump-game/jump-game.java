class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        // 0 = not visited
        // 1 = can reach end
        // -1 = cannot reach end

        return helper(nums, 0, dp);
    }

    private boolean helper(int[] nums, int index, int[] dp) {
        if (index >= nums.length - 1)
            return true;

        if (dp[index] != 0)
            return dp[index] == 1;

        for (int jump = 1; jump <= nums[index]; jump++) {
            if (helper(nums, index + jump, dp)) {
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = -1;
        return false;
    }
}