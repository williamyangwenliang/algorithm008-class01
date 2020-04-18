class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] < 9){
				//末位数加1后<=9则说明不需要进位，末位加一后返回即可
                digits[i]++;
                return digits;
            } else{
                digits[i]=0;;
            }
        }
		//新数组只需要设置第一个数字即可，因为+1后的结果到这里只能是100000......
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;        
    }
}