class Solution {

    static boolean compareFreq(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Frequency table of s1
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        int windowLength = s1.length();

        // First window of s2
        for (int i = 0; i < windowLength; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (compareFreq(count1, count2)) {
            return true;
        }

        // Process remaining windows
        int i = windowLength;

        while (i < s2.length()) {

            // Add new character
            char newChar = s2.charAt(i);
            count2[newChar - 'a']++;

            // Remove old character
            char oldChar = s2.charAt(i - windowLength);
            count2[oldChar - 'a']--;

            // Compare frequency tables
            if (compareFreq(count1, count2)) {
                return true;
            }

            i++;
        }

        return false;
    }
}
