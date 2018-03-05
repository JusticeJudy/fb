public void rotate(int[] nums, int k) {
        if (k == nums.length) return;
        if (k > nums.length) k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return;
}
    private void reverse(int[] nums , int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        return;
}
