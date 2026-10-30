class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        char firstChar = 0, secondChar = 0;
        int firstCount = 0, secondCount = 0;
        char c;
        int ans = 0;
        while(r<n){
            c = chars[r];
            if(c!=firstChar && c!=secondChar){
                while(firstCount!=0 && secondCount!=0){
                    if(chars[l]==firstChar)firstCount--;
                    else secondCount--;
                    l++;
                }
                if(firstCount==0){
                    firstCount++;
                    firstChar = c;
                }else{
                    secondCount++;
                    secondChar = c;
                }
            }else if(c==firstChar){
                firstCount++;
            }else{
                secondCount++;
            }
            ans = Math.max(r-l+1,ans);
            r++;
        }
        return ans;
    }
}