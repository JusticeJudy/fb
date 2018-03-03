// '+', '-' '(' ')'

public int calculate(String s) {
  if (s == null) {
    return 0;
  }
  Stack<Integer> stack = new Stack<Integer>();
  int result = 0;
  int sign = 1;
  for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) == ' ') {
      continue;
    }
    if (Character.isDigit(s.charAt(i)) {
      int num = s.charAt(i) - '0';
      while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)) {
        num = num * 10 + s.charAt(i + 1) - '0';
        i++;
      }
      result += num * sign;
    } else if (s.charAt(i) == '+') {
      sign = 1;
    } else if (s.charAt(i) == '-') {
      sign = -1;
    } else if (s.charAt(i) == '(') {
      stack.push(result);   // store previous result
      stack.push(sign);     // store previous sign
      result = 0;
      sign = 1;
    } else if (s.charAt(i) == ')') {
      result = result * stack.pop() + stack.pop();
    }
  }
  return result;
}

// '+ - * /' no '()'

public int calculate(String s) {
  if (s == null || s.length() == 0) {
    return 0;
  }
  Stack<Integer> stack = new Stack<Integer>();
  int result = 0;
  char sign = '+';
  int num = 0;
  for (int i = 0; i < s.length(); i++) {
    // get number first
    if (Character.isDigit(s.charAt(i))) {
      num = s.charAt(i) - '0';
      while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
        num = num * 10 + s.charAt(i + 1) - '0';
        i++;
      }
    }
    // now apply operator
    if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
      if (sign == '+') {
        stack.push(num);
      } else if(sign == '-') {
        stack.push(-num);
      } else if (sign == '*') {
        stack.push(stack.pop() * num);
      } else if (sign == '/') {
        stack.push(stack.pop()/num);
      }
      sign = s.charAt(i);
      num = 0;
    }
  }
  for (int i : stack) {
    result += i;
  }
  return result;
}
