class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Store non-zero digits and their positions
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                posList.add(i);
                digitList.add(d);
            }
        }

        int k = posList.size();

        int[] pos = new int[k];
        int[] digit = new int[k];

        for (int i = 0; i < k; i++) {
            pos[i] = posList.get(i);
            digit[i] = digitList.get(i);
        }

        long[] pow10 = new long[k + 1];
        pow10[0] = 1;
        for (int i = 1; i <= k; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        long[] prefNum = new long[k + 1];
        long[] prefSum = new long[k + 1];

        for (int i = 0; i < k; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digit[i]) % MOD;
            prefSum[i + 1] = prefSum[i] + digit[i];
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[qi] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = (prefNum[right + 1]
                    - prefNum[left] * pow10[len] % MOD
                    + MOD) % MOD;

            long sum = prefSum[right + 1] - prefSum[left];

            ans[qi] = (int) (x * (sum % MOD) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}