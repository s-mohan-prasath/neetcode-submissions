class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, c = 0,lastZero = -1;
        int n = nums.length;
        int maxOnes = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            if(nums[i]==0){
                if(c==0){
                    c++;
                }else{
                    l = lastZero+1;
                }
                lastZero = i;
            }
            maxOnes = Math.max(maxOnes,i-l+1);
        }
        return maxOnes;
    }
}
