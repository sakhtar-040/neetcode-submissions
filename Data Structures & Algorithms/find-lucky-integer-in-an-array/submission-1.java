class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501]; // arr[i] is in [1, 500]

        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) return i; // largest lucky first
        }

        return -1;
    }
}