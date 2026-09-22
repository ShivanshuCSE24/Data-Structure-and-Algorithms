class Solution {
    public int[] plusOne(int[] digits) {

        int len = digits.length - 1;

        while(len >= 0){
            if(digits[len] < 9){

                digits[len]++;
                return digits;

            }
            else{
                digits[len] = 0;
            }
            len--;
        }

        int[] result = new int[digits.length + 1];

        result[0] = 1;
        return result;
    } 
}