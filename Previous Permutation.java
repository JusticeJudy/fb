//https://www.nayuki.io/page/next-lexicographical-permutation-algorithm

Previous Permutation
// To find the previous permutation, we mean finding the the number that is right in front of it in an ascending order, just
 	// a tad smaller. 
2764135 （找最后一个逆序41）
// The above example, we loop from the end of array. Find the dip of the trend, right when the digits start to pick up.
 // which is 4 in this case, and we want to swap this with a digit that is smaller than 4 and closest to 1's position, 
  // which is 3.
 // after we swop it, we reverse the order of the array from the original 4's position.
2764135 （找4后面比4小的最后一个数3）
2763145 （交换3,4的位置）
2763541 （把3后面的1,4,5反转）

public void previousPermuation(int[] nums) {
	if (nums.length < 2)    return;
	// Index of the number before first dip 
    int firstLarger = nums.length - 2;
    while (firstLarger >= 0) {
        if (nums[firstLarger] > nums[firstLarger + 1])    break;
        firstLarger--;
    }
    
    // if index equals -1, the number itself is the smallest in the ascending order, so we reverse whole array.
    	// ask them first, what to do with the number that is front of the queue already
    if (firstLarger == -1) { 
        reverse(nums, 0, nums.length - 1);
        return;
    }
    int firstSmaller = nums.length - 1;
    while (firstSmaller > firstLarger) {
        if (nums[firstSmaller] < nums[firstLarger])    break;
        firstSmaller--;
    }
    swap(nums, firstLarger, firstSmaller);
    reverse(nums, firstLarger + 1, nums.length - 1);
}
private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left++] = nums[right];
    nums[right--] = temp;
}
private void reverse(int[] nums, int left, int right) {
    while (left < right) 
        swap(nums, left++, right--);
}





31. Next Permutation
// https://leetcode.com/problems/next-permutation/

// To find the previous permutation, we mean finding the the number that is right after it in an ascending order, just a tad
  // larger.
2763541 （找最后一个正序35）
// The above example, we loop from the end of array. Find the peak of the trend, right when the digits start to climb down.
 // which is 3 in this case, and we want to swap this with a digit that is bigger than 3 and closest to 1's position, 
  // which is 4.
 // after we swop it, we reverse the order of the array from the original 3's position.
2763541 （找3后面比3大的最后一个数4）
2764531 （交换3,4的位置）
2764135 （把4后面的5,3,1反转）

public void nextPermutation(int[] nums) {
    if (nums.length < 2)    return;
    // find the index of the number right before the first peak
    int firstSmaller = nums.length - 2;
    while (firstSmaller >= 0) {
        if (nums[firstSmaller] < nums[firstSmaller + 1])    break;
        firstSmaller--;
    }
    // if index equals -1, the number itself is the biggest in the ascending order, so we reverse whole array.
    	// ask them first, what to do with the number that is at the end of the queue already
    if (firstSmaller == -1) {
        reverse(nums, 0, nums.length - 1);
        return;
    }
    int firstLarger = nums.length - 1;
    while (firstLarger > firstSmaller) {
        if (nums[firstLarger] > nums[firstSmaller])    break;
        firstLarger--;
    }
    swap(nums, firstSmaller, firstLarger);
    reverse(nums, firstSmaller + 1, nums.length - 1);
    return;
}
private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
private void reverse(int[] nums, int start, int end) {
    for (int i = start; i <= (start + end) / 2; i++)
        swap(nums, i, start + end - i);
}



















