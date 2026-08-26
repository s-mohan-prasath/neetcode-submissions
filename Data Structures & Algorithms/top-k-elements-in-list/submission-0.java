class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int maxFreq = 0, len = nums.length;
        int[] freq = new int[20001];
        int i, j;
        for (i = 0; i < len; i++) {
            maxFreq = Math.max(++freq[10000 + nums[i]], maxFreq);
        }
        List<Integer>[] arr = new ArrayList[maxFreq+1];
        int x;
        for (i = 0; i <= 20000; i++) {
            if(freq[i]==0)continue;
            x = i - 10000;
            if (arr[freq[i]] == null) {
                arr[freq[i]] = new ArrayList();
            }
            arr[freq[i]].add(x);
        }
        i = 0;
        j = maxFreq;
        x = 0;
        int[] out = new int[k];
        while (i < k) {
            if (j>=0 && arr[j] != null) {
                for (Integer a : arr[j]) {
                    out[x++] = a;
                    if(++i>=k)break;
                }
            }
            j--;
        }
        return out;
    }
}