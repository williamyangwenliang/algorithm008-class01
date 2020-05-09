class Solution {
    /**
     * 解题思路：记录5元和10元的库存，每次找零后计算库存，当出现<0的情况即为非法
     */
    public boolean lemonadeChange(int[] bills) {
        int c5 = 0, c10 = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    c5++;
                    break;
                case 10:
                    if (--c5 < 0) return false;
                    c10++;
                    break;
                default:
                    if (c10 > 0) {
                        c10--;
                        c5--;
                    } else {
                        c5 -= 3;
                    }
                    if (c5 < 0 || c10 < 0) return false;
            }
        }
        return true;
    }
}