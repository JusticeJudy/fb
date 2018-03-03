// Given custom alphabet order. 

Map<Character, Integer> map = new HashMap<Character, Integer>();
for (int i = 0; i < order.length; i++) {
    map.put(order[i], i);
}

Arrays.sort(str, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        for (int i = 0; i < Math.min(aa.length, bb.length); i++) {
            if (aa[i] != bb[i]) {
                int orderA = map.get(aa[i]);
                int orderB = map.get(bb[i]);
                return orderA - orderB;
            }
        }
        return aa.length - bb.length;
    }
});





public String[] wordSort(char[] alphabet, String[] words) {
        // Write your code here
        char []Into = new char[1000];
        char []Outto = new char[1000];
        for(int i = 0; i < alphabet.length; i++) {
            // translate the custom alphabet into a lookup table
        //0,1,2,3,4,5,6,7,8,9,10,
      // {z,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,c} ->
      // {c,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,a}
            Into[(int)alphabet[i]] = (char)('a' + i);
            Outto['a' + i] = alphabet[i];
        }
        for(int i = 0; i < words.length; i++) {
            String temp = new String();
            for(int j = 0; j < words[i].length(); j++) {
                temp += Into[(int)words[i].charAt(j)];
            }
            words[i] = temp;
        }
        Arrays.sort(words);
        for(int i = 0; i < words.length; i++) {
            String temp = new String();
            for(int j = 0; j < words[i].length(); j++) {
                temp += Outto[(int)words[i].charAt(j)];
            }
             words[i] = temp;
        }
        return words;
    }
}
