class Solution {
    /**
     * 解题思路：给2个数组排序，先用小饼干喂胃口小的孩子，
     * 如果小饼干不够量，则移动指针，直到饼干派完或没有孩子需要饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                gi++;
            } 
            si++;
        }
        return gi;
    }
}