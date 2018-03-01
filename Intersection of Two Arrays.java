public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
             return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx1 = 0, idx2 = 0;
        Set<Integer> set = new HashSet<Integer>();

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]) {
                set.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        int[] result = new int[set.size()];
        int i = set.size();
        for (Integer num : set) {
            result[--i] = num;   
        }
        return result;
}
