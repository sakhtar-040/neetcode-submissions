class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();

        int i=0;
        int j=i+1;

        while(i < nums2.length) {
            if(j == nums2.length) {
                map.put(nums2[i], -1);
                i++;
            } else if(nums2[j] > nums2[i]) {
                map.put(nums2[i], nums2[j]);
                i++;
                j=i+1;
            } else if (nums2[j] < nums2[i]) {
                j++;
            } else {
                map.put(nums2[i], -1);
            }
        }

        for(int k=0;k<nums1.length;k++) {
            result[k] = map.get(nums1[k]);
        }

        return result;
    }
}