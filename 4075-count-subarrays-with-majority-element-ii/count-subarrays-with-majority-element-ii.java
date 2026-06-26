class Solution {
    class Fenwick {
        long[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 1];
        }

        void update(int idx, long val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int offset = n + 1;
        Fenwick bit = new Fenwick(2 * n + 5);

        long ans = 0;
        int prefix = 0;

        // prefix sum = 0 initially
        bit.update(offset, 1);

        for (int num : nums) {
            prefix += (num == target) ? 1 : -1;

            int idx = prefix + offset;

            // count previous prefix sums smaller than current
            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}