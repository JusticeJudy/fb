161. One Edit Distance
// https://leetcode.com/problems/one-edit-distance/


Tests: 1.replace one char, 2.delete one char in s, 3.delete one char in t
corner cases: "" (len = 0)

public boolean isOneEditDistance(String s, String t) {
    int len = Math.min(s.length(), t.length());
    for (int i = 0; i < len; i++) {
        if (s.charAt(i) != t.charAt(i)) {
            if (s.length() == t.length())   return s.substring(i + 1).equals(t.substring(i + 1)); // replace
            else if (s.length() < t.length())   return s.substring(i).equals(t.substring(i + 1)); // delete t
            else    return s.substring(i + 1).equals(t.substring(i)); // delete s
        }
    }
    return Math.abs(s.length() - t.length()) == 1; // corner case: ""
}

原题 但是不能用substring ====>>>   要一个字符一个字符比较



public boolean isOneEditDistance(String s, String t) {
    if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
        return false;
    }
    
    int m = s.length();
    int n = t.length();
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    
    if (m == n) {
        return checkCase1(sc, tc);
    } else if (m > n) {
        return checkCase23(sc, tc);
    } else {
        return checkCase23(tc, sc);
    }
}
private boolean checkCase1(char[] sc, char[] tc) {
    int m = sc.length;
    int n = tc.length;
    int i = 0, j = 0, count = 0;
    while (i < m && j < n) {
        if (sc[i++] != tc[j++]) {
            count++;
        }
    }
    if (count > 1) {
        return false;
    }
    return true;
}

private boolean checkCase23(char[]sc, char[] tc) {
    int m = sc.length;
    int n = tc.length;
    int i = 0, j = 0, count = 0;
    while (i < m && j < n) {    // only one chanse of discrepency and skip one char
        if (sc[i] != tc[j]) {
            i++;
            count++;
        } else {
            i++;
            j++;
        }
    }
    if (count > 1) {
        return false;
    }
    return true;
}
