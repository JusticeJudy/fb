Monotonous Array

判断 个序 是否是递增递减序 

就一个Boolean flag表示是否已经确定了方向以及方向是什么，从前往后搜。

public boolean checkMonotone(int[] nums) {
  if (nums.length <= 2) {
      return true;
  }
  boolean flag = nums[1] - nums[0] > 0;
  
  for (int i = 1; i < nums.length; i++) {
    if (nums[i] - nums[i - 1] > 0 != flag) {
        return false;
    }
    if (nums[i] == nums[i - 1]) {
        return false;
    }
  }
  return true;
}
