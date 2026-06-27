class Solution {

    // Find pivot index
    public int findPivotIndex(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;

        if (nums[s] < nums[e]) {
            // Array is not rotated
            return -1;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= nums[n - 1]) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    // Normal Binary Search
    public int binarySearch(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums);
        int n = nums.length;

        // Array is not rotated
        if (pivotIndex == -1) {
            return binarySearch(nums, 0, n - 1, target);
        }

        int startArray1 = 0;
        int endArray1 = pivotIndex;

        if (target >= nums[startArray1] && target <= nums[endArray1]) {
            return binarySearch(nums, startArray1, endArray1, target);
        }

        int startArray2 = pivotIndex + 1;
        int endArray2 = n - 1;

        if (target >= nums[startArray2] && target <= nums[endArray2]) {
            return binarySearch(nums, startArray2, endArray2, target);
        }

        return -1;
    }
}