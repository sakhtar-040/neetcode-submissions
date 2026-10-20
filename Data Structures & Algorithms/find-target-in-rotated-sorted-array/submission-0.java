class Solution {
    public static int search(int[] nums, int target) {
        int rotatedIndex = getRotatedIndex(nums);
        int searchInLeft = searchBinary(nums, target, 0, rotatedIndex - 1);
        if(searchInLeft != -1) {
            return searchInLeft;
        }
        return searchBinary(nums, target, rotatedIndex, nums.length - 1);
    }

    private static int searchBinary(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int getRotatedIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
