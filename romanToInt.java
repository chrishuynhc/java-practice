class Solution {
    public int romanToInt(String s) {
        
        int num = 0;     
        char[] romanNumeral = s.toCharArray();
        int[] nums = new int[romanNumeral.length];
        
        for (int i = 0; i < romanNumeral.length; i++){
            
            if (romanNumeral[i] == 'I'){
                nums[i] = 1;
            }
            else if (romanNumeral[i] == 'V'){
                nums[i] = 5;
            }
            else if (romanNumeral[i] == 'X'){
                nums[i] = 10;
            }
            else if (romanNumeral[i] == 'L'){
                nums[i] = 50;
            }
            else if (romanNumeral[i] == 'C'){
                nums[i] = 100;
            }
            else if (romanNumeral[i] == 'D'){
                nums[i] = 500;
            }
            else if (romanNumeral[i] == 'M'){
                nums[i] = 1000;
            }    
        }
        
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] < nums[i + 1]){
                num -= nums[i];
            } else {
                num += nums[i];
            }
            
        }
        
        return num + nums[nums.length - 1];
    }
}