class Solution {
    public boolean containsNearbyAlmostDuplicate(
            int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long current = nums[i];

            Long ceiling = set.ceiling(current);
            if (ceiling != null &&
                ceiling - current <= valueDiff) {
                return true;
            }

            Long floor = set.floor(current);
            if (floor != null &&
                current - floor <= valueDiff) {
                return true;
            }

            set.add(current);

            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}