public int trap(int[] height) {
       if(height.length<3) return 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        int water = 0;
        
        for(int i=1; i<height.length; i++) {
            if(height[i]>height[s.peek()]) {
                int bottom = height[s.peek()];
                s.pop();
                while(!s.empty() && height[i]>=height[s.peek()]) {
                    water += (height[s.peek()]-bottom) * (i - s.peek() - 1);
                    bottom = height[s.peek()];
                    s.pop();
                }
                if(!s.empty()) water += (height[i]-bottom) * (i - s.peek() - 1);
            }
            s.push(i);
        }
        
        return water;

    }
    
    // Two pointer. 
    public int trap(int[] height) {
        if(height.length<3) return 0;
        int[] leftH = new int[height.length];
        int[] rightH = new int[height.length];
        int water = 0;
        
        leftH[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftH[i] = Math.max(height[i - 1], leftH[i - 1]);            
        }
        
        rightH[height.length - 1] = 0;
        int minHeight = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightH[i] = Math.max(height[i + 1], rightH[i + 1]);
            minHeight = Math.min(rightH[i], leftH[i]);
            if (minHeight >= height[i]) {
                water += minHeight - height[i];
            }
        }
        return water;
    }
