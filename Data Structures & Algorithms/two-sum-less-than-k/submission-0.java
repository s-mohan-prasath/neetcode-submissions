class Solution {
    int[] aux, nums;
    int temp;
    public int twoSumLessThanK(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE,sum;
        int n = nums.length;
        this.nums = nums;
        aux = Arrays.copyOf(nums, n);
        // merge sort
        mergeSort(0, n - 1);
        int l = 0, r = n-1;
        while(l<r){
            sum = nums[l]+nums[r];
            if(sum>=k){
                r--;
            }else{
                maxSum = Math.max(maxSum,sum);
                l++;
            }
        }
        return maxSum==Integer.MIN_VALUE ? -1 : maxSum;
    }
    private void mergeSort(int a, int b) {
        if (a >= b)
            return;
        if (a + 1 == b) {
            if (nums[a] > nums[b]) {
                temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
            }
        } else {
            int mid = (a + b) / 2;
            mergeSort(a, mid);
            mergeSort(mid + 1, b);
            merge(a, mid, mid + 1, b);
        }
    }
    private void merge(int a, int b, int a2, int b2) {
        int s = a, k = a;
        while (a <= b || a2 <= b2) {
            if (a <= b && a2 <= b2) {
                if (nums[a] <= nums[a2]) {
                    aux[k++] = nums[a++];
                }else{
                    aux[k++] = nums[a2++];
                }
            } else if (a <= b) {
                while (a <= b) aux[k++] = nums[a++];
            } else {
                while (a2 <= b2) aux[k++] = nums[a2++];
            }
        }
        while (s < k) nums[s] = aux[s++];
    }
}
