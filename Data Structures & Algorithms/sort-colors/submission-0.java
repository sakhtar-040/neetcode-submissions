class Solution {
    private static void heapify(int[] nums, int size, int root) {
        while (true) {
            int largest = root;
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            if (left < size && nums[left] > nums[largest]) {
                largest = left;
            }

            if (right < size && nums[right] > nums[largest]) {
                largest = right;
            }

            if (largest == root) return;

            int temp = nums[root];
            nums[root] = nums[largest];
            nums[largest] = temp;
            root = largest;
        }
    }

    private static int[] heapSortArray(int[] nums) {
        int n = nums.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Move maximum elements to the end
        for (int end = n - 1; end > 0; end--) {
            int temp = nums[0];
            nums[0] = nums[end];
            nums[end] = temp;

            heapify(nums, end, 0);
        }

        return nums;
    }

    public void sortColors(int[] nums) {
        heapSortArray(nums);
    }
}