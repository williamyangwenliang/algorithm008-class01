class Solution {
    /**
     * 解题思路：由于字符串仅由小写字母组成，因而可以将s的字符转成数组下标，并用一个26长度的数组记录
     * 各字符出现的频次，再遍历t字符串，逐一修改数组上的频次数据，如有出现频次数低于0则不符合规则
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sa = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sa[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int ti = t.charAt(i) - 'a';
            if (--sa[ti] < 0) return false;
        }
        return true;
    }
}