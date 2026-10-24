class Solution {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            result.append(ch);
        }

        return result.toString();
    }
}