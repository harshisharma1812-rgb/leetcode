class Solution {

    static void solve(int[] candidates, int target, int index,
                      List<List<Integer>> ans, List<Integer> output,
                      int count, int k) {

        if (count > k)
            return;

        if (count == k && target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (index >= candidates.length || target < 0)
            return;

        // Include
        output.add(candidates[index]);
        solve(candidates, target - candidates[index], index + 1,
                ans, output, count + 1, k);

        // Backtrack
        output.remove(output.size() - 1);

        // Exclude
        solve(candidates, target, index + 1,
                ans, output, count, k);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int[] candidates = {1,2,3,4,5,6,7,8,9};

        solve(candidates, n, 0, ans, output, 0, k);

        return ans;
    }
}