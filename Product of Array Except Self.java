public int[] productExceptSelf(int[] nums) {
        int[] productFB = new int[nums.length];
        int[] result = new int[nums.length];
        // keep an array that records the accumulated products from behind
        productFB[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            productFB[i] = nums[i] * productFB[i + 1]; 
        }
        
        result[0] = productFB[1];
        int fProduct = 1;
        for (int i = 1; i < nums.length - 1; i++) {
        // As front product
            fProduct *= nums[i - 1];
            result[i] = fProduct * productFB[i + 1];
        }
        result[nums.length - 1] = fProduct * nums[nums.length - 2];
        return result;
}
