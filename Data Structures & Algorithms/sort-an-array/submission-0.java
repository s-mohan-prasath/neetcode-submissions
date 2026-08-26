class Solution {
    int[] arr;
    int[] assist;
    int temp;

    public int[] sortArray(int[] nums) {
        arr = nums;
        assist = new int[nums.length];
        sort(0, nums.length - 1);
        return arr;
    }

    private void sort(int i, int j) {
        if (i == j) {
            return;
        }
        if (i + 1 == j) {
            if (arr[i] > arr[j]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } else {
            int m = (i + j) / 2;
            sort(i, m);
            sort(m + 1, j);
            merge(i, m, m + 1, j);
        }
    }

    private void merge(int a, int b, int c, int d) {
        int p1 = a, p2 = c;
        int x = p1;
        while (p1 <= b || p2 <= d) {
            if (p1 <= b && p2 <= d) {
                if (arr[p1] <= arr[p2]) {
                    assist[x++] = arr[p1];
                    p1++;
                } else {
                    assist[x++] = arr[p2];
                    p2++;
                }
            } else if (p1 <= b) {
                while (p1 <= b) {
                    assist[x++] = arr[p1];
                    p1++;
                }
                break;
            } else {
                while (p2 <= d) {
                    assist[x++] = arr[p2];
                    p2++;
                }
                break;
            }
        }
        for (int i = a; i <= d; i++) {
            arr[i] = assist[i];
        }
    }
}