Time: O(N^4)
SPACE: O(1)
private void equalTwoSumPair(int[] nums){
        for(int a = 0; a<nums.length-1;a++){
            for(int b = a+1; b<nums.length;b++){
                long sum = nums[a] + nums[b];
                for(int c = 0; c<nums.length-1; c++){
                    for(int d = c+1; d<nums.length;d++){
                    if(nums[d]+nums[c]==sum&&(d>b||d==b&&c>a)){
                    //Both work: if(nums[d]+nums[c]==sum&&(c<=a&&d>b||c>a&&d>=b)
                            System.out.println("("+a+","+b+","+c+","+d+")");
                        }
                    }
                }
            }
        }
    }
