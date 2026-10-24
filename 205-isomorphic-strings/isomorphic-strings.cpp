class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int a[256] = {}, b[256] = {};

        for (int i = 0; i < s.size(); i++) {
            if (a[(unsigned char)s[i]] != b[(unsigned char)t[i]])
                return false;

            a[(unsigned char)s[i]] = i + 1;
            b[(unsigned char)t[i]] = i + 1;
        }

        return true;
    }
};