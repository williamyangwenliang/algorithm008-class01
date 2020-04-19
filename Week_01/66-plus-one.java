class Solution {
	/**
	 *题目：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	 *最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	 *你可以假设除了整数 0 之外，这个整数不会以零开头。
	 *
	 *解题思路：如果数组末位数小于9，直接加1即可返回，如果=9，则需要进位，本位数改为0，对于类似9999....这种数据，则数组长度需要加1，并且首位数字为1，后面为0
	 */
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            } else{
                digits[i]=0;;
            }
        }
		//新数组只需要设置第一个数字即可，后面使用默认值0，因为+1后的结果到这里只能是100000......
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;        
    }
}