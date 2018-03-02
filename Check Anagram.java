// check one of the first string's permutations is the substring of the second string.

public boolean checkInclusion(String s1, String s2) {
      int total = s1.length();
      int n = total;
      int[] hash = new int[128];
      for (int i = 0; i < n; i++) {
          hash[s1.charAt(i)]++;
      }
      int leftMost = 0;
      for (int i = 0; i < s2.length(); i++) {
          char c = s2.charAt(i);
          if (hash[c] > 0) {
              total--;
          }
          hash[c]--;
          while (total == 0) {
              char left = s2.charAt(leftMost);
              if (n == i - leftMost + 1) {
                  return true;
              }
              hash[left]++;
              if (hash[left] > 0) {
                  total++;
              }
              leftMost++;
          }
      }
      return false;
  }
  
 // return the first index of the anagram found in s2
 
  public int checkInclusion(String s1, String s2) {
      int total = s1.length();
      int n = total;
      int[] hash = new int[128];
      for (int i = 0; i < n; i++) {
          hash[s1.charAt(i)]++;
      }
      int leftMost = 0;
      for (int i = 0; i < s2.length(); i++) {
          char c = s2.charAt(i);
          if (hash[c] > 0) {
              total--;
          }
          hash[c]--;
          while (total == 0) {
              char left = s2.charAt(leftMost);
              if (n == i - leftMost + 1) {
                  return leftMost;
              }
              hash[left]++;
              if (hash[left] > 0) {
                  total++;
              }
              leftMost++;
          }
      }
      return -1;
  }
