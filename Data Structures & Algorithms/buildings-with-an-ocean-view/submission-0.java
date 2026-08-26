class Solution {
    public int[] findBuildings(int[] arr) {
        int[] out;
        int len = arr.length;
        int[] stack = new int[len];
        int top = -1;
        for (int i = 0; i < len; i++) {
            while (top >= 0 && arr[stack[top]] <= arr[i]) {
                top--;
            }
            stack[++top] = i;
        }
        out = new int[top + 1];
        for (int i = 0; i <= top; i++) {
            out[i] = stack[i];
        }
        return out;
    }
}