import java.io.*;
import java.util.*;

 /*
給你一個 1d 的 arrary ， array 的每個 element 是 1 ~ 9 的數字，所以這個 array 同時也代表一個數字
現在允許你對其中的 2 個 element 作 swap ，要求 return 經過一次 swap 之後，所能產生的最大數字。. 1point3acres.com/bbs
EX: [3,2,1,4] --> 代表數字 3214 。如果我們交換 3 跟 4 ，就會得到 [4,2,1,3] --> 代表數字 4213 。

我一開始沒有好的想法，只想說要把比較大的數字從比較右邊，交換到比較左邊。
於是乎想法就變成：從 MSB 往右找，找到比 MSB 大最多且最靠右的數字作交換。上面的例子很自然是 3 與 4 作交換。
另一個例子：[3,2,5,5] --> [5,2,5,3] 5 是比 MSB 大最多的數字，但是我們要與最靠右的作交換
另一個例子：[6,2,4,5] --> [6,5,4,2] 因為沒有比 MSB 大的數字，我們往下一位去作。
 */

class Solution {
    static int[] nums = {3,2,5,5};

// 2D array, keep track of each index’s biggest number from itself to end of array, record the number and the index
    static int[][] dp = new int[nums.length][2];
    
    
    
    public  static int[] np(int[] nums) {
        // if input is an Integer
     /*
        String numS = String.valueOf(num);
        char[] c = numS.toCharArray();
        int[] nums = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            nums[i] = Character.getNumericValue(c[i]);
        }
     */
        int[][] dp = new int[nums.length][2];
        dp(0, nums, dp);
        for (int i = 0; i < dp.length; i++) {
// first number that has a biggest number to its right, swap it with that number. (index is already recorded, 
//no need to search for that big number.)
            if (nums[i] < dp[i][0]) {
                swap(nums, i, dp[i][1]);
                break;
            }
        }
        return nums;
     
       /*  if input is an Integer
          StringBuilder sb = new StringBuilder();
           for (int n : nums) sb.append(n);
           String s = sb.toString();
           return Integer.valueOf(s);
        */
    }
    
    private static void dp(int i, int[] nums,int[][] dp) {
        if (i >= nums.length - 1) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
            return;
        }
        dp(i + 1, nums, dp);
        dp[i][0] = (dp[i + 1][0] >= nums[i])? dp[i + 1][0]: nums[i];
        dp[i][1] = (dp[i + 1][0] >= nums[i])? dp[i + 1][1]: i;
        return;   
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }             
                 
}

