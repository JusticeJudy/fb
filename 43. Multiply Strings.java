43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

我们以289*785为例
// http://www.cnblogs.com/TenosDoIt/p/3735309.html

public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return "";   
        }
        
        int n1 = num1.length(), n2 = num2.length();
        int[] digits = new int[n1 + n2];
        int k = n1 + n2 - 2, carry = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                digits[k - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = 0; i < n1 + n2; i++) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        
        int i = n1 + n2 - 1;
        while (i >= 0 && digits[i] == 0) i--;
        if (i < 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            sb.append(digits[i--]);
        }
        return sb.toString();
}

public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] posNum = new int[m + n]; // important
    for (int i = m - 1; i >= 0; i--)
        for (int j = n - 1; j >= 0; j--) {
            int multiple = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            int p1 = i + j, p2 = i + j + 1;
            int sum = multiple + posNum[p2];
            posNum[p1] += sum / 10; // important
            posNum[p2] = sum % 10; // important
        }
    }
    StringBuilder sb = new StringBuilder();
    for (int num : posNum)
        if (!(sb.length() == 0 && num == 0))    sb.append(num);
    return sb.length() == 0 ? "0" : sb.toString();
}

     56
 *   22
---------
    112
   112
---------
