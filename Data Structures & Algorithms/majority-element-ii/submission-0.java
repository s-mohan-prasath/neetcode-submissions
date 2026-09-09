class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> out = new ArrayList<>();
        int len = nums.length;
        int t = len / 3;
        Integer a = null, b = null;
        int an = 0, bn = 0;
        for (int n : nums) {
            if (an==0) {
                if(b!=null && b==n)bn++;
                else{
                    a = n;
                    an++;
                }
            }
            else if (bn==0) {
                if(a!=null && a==n)an++;
                else{
                    b = n;
                    bn++;
                }
            } 
            else if (n == a)
                an++;
            else if (n == b)
                bn++;
            else {
                an--;
                bn--;
            }
        }
        int x = 0, y = 0;
        for (int n : nums) {
            if (a != null && n == a)
                x++;
            if (b != null && n == b)
                y++;
        }
        if (x > t)
            out.add(a);
        if (y > t)
            out.add(b);
        return out;
    }
}