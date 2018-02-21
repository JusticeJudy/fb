public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || n == 0) {
            return;
        }
        int mainIdx = m + n - 1, oneIdx = m - 1, twoIdx = n - 1;
        
        while (oneIdx >= 0 && twoIdx >= 0) {
            if (nums1[oneIdx] >= nums2[twoIdx]) {
                nums1[mainIdx--] = nums1[oneIdx--];
            } else {
                nums1[mainIdx--] = nums2[twoIdx--];
            }
        }
        while (twoIdx >= 0) {
            nums1[mainIdx--] = nums2[twoIdx--];
        }
        return;
  }
