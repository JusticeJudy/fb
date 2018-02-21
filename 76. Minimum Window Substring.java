76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] counts = new int[256];
        
        for (char c : t.toCharArray()) {
            counts[c]++;   
        }
        
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        int total = t.length();
        for (int left = 0, right = 0; right < s.length(); right++) {
            if ((counts[s.charAt(right)]--) > 0) {
                total--;   
            }
          // while total count still zero, shrink the window by the left pointer, as long as total is still zero, there's room
            // to shrink the window
            while (total == 0){
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    minStart = left;
                }
                counts[s.charAt(left)]++;
                if(counts[s.charAt(left)] > 0) {
                    total++;
                }
                left++;
            }
        }
        return (min == Integer.MAX_VALUE)? "": s.substring(minStart, minStart + min);
}

扣76,   样的是T给的是set,  会有重复,  样瞬秒， 开始问我时间复杂度，我说O(n)他 开始 顿扯，我说T的size 并 影响，最后 他同意
最后要我写test case, 后来当T 是空的时候会有问题， 我 上改 bug就结束让我问问题 
