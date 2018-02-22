public List<List<Integer>> palindromePairs(String[] words) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (words == null || words.length == 0) {
                return result;
            }
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i], i);
                set.add(words[i].length());
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j <= words[i].length(); j++) {
                    String str1 = words[i].substring(0, j);
                    String str2 = words[i].substring(j);
                    
                    if (isPalindrome(str1)) {
                        String str2Reversed = new StringBuilder(str2).reverse().toString();
                        if (map.containsKey(str2Reversed) && map.get(str2Reversed) != i) {
                            result.add(Arrays.asList(map.get(str2Reversed), i));
                        }
                    }
                    if (str2.length() > 0 && isPalindrome(str2)) {
                        String str1Reversed = new StringBuilder(str1).reverse().toString();
                        if (map.containsKey(str1Reversed) && map.get(str1Reversed) != i) {
                            result.add(Arrays.asList(i, map.get(str1Reversed)));
                        }
                    }
                }
            }
            return result;
        }
        private boolean isPalindrome(String word) {
            int start = 0, end = word.length() - 1;
            while (start < end) {
                if (word.charAt(start++) != word.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }
