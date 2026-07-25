class Solution {

    public void solve(int[] nums, int index, List<List<Integer>> ans) {

        // Base Case
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        // Generate permutations
        for (int i = index; i < nums.length; i++) {

            // Swap
            int t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;

            // Recursive call
            solve(nums, index + 1, ans);

            // Backtrack (swap back)
            t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, ans);

        return ans;
    }
}