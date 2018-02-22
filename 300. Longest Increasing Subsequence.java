300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

//我们先建立一个数组ends，把首元素放进去，然后比较之后的元素，如果遍历到的新元素比ends数组中的首元素小的话，替换首元素为此新元素，
// 	如果遍历到的新元素比ends数组中的末尾元素还大的话，将此新元素添加到ends数组末尾(注意不覆盖原末尾元素)。如果遍历到的新元素
// 	比ends数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，覆盖掉位置的原来的数字，以此类推直至遍历完整个nums数组，
// 	此时ends数组的长度就是我们要求的LIS的长度，特别注意的是ends数组的值可能不是一个真实的LIS，比如若输入数组nums为{4, 2， 4， 5， 3， 7}，
// 	那么算完后的ends数组为{2， 3， 5， 7}，可以发现它不是一个原数组的LIS，只是长度相等而已，千万要注意这点。
   
	
//二分法可以这么理解，比如nums 之前为[4, 5, 6, 3], 现在nums[i] = 4, tails = [3, 5, 6], 那我们用二分法把5替换成4, 
// 	得到[3, 4, 6]. 意味着长度为2的LIS现在最小的尾巴是4. 正确性其实不难看出. 因为4比3大, 也就是长度为1的LIS [3]可以和4形成
// 	一个长度为2的LIS[3, 4]. 而原来长度为2的LIS[4, 5] 由于4比5小5就被替换下去了.
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  
        }
        int[] tails = new int[nums.length];
        int result = 0;
        for (int num : nums) {
            int i = 0, j = result;
            while (i != j) {
                int mid = (j - i)/2 + i;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;   
                }
            }
            tails[i] = num;
            if (i == result) {
                result++;  
            } 
        }
        return result;
    }
}
	
	
Solution 1: DP 
Time: O(n^2)

注意，是返回max不是返回数组最后一个，所以中间要维护这个max变量

public int lengthOfLIS(int[] nums) {
	int[] dp = new int[nums.length];
	Arrays.fill(dp, 1);
	int max = 1;
	for (int i = 1; i < nums.length; i++)
		for (int j = 0; j < i; j++) 
			if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
				dp[i] = dp[j] + 1;
				max = Math.max(max, dp[i]);
			}
	return max;
}


Solution 2: DP with Binary Search
// The idea is that as you iterate the sequence, you keep track of the minimum value a subsequence of given length might end with, 
// for all so far possible subsequence lengths. So dp[i] is the minimum value a subsequence of length i+1 might end with. 
// Having this info, for each new number we iterate to, we can determine the longest subsequence where it can be appended using binary search. 
// The final answer is the length of the longest subsequence we found so far.
Time: O(nlogn)

public int lengthOfLIS(int[] nums) {
	int[] dp = new int[nums.length];
	int len = 0;
	for (int n : nums) {
		int i = Arrays.binarySearch(dp, 0, len, n);
		if (i < 0)	i = - (i + 1);
		dp[i] = n;
		if (i == len)	len++;
	}
	return len;
}
// Arrays.binarySearch() returns ( - insertion_index - 1) in cases where the element was not found in the array. 
