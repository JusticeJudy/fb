
private Stack<NestedInteger> Stack;
public NestedIterator(List<NestedInteger> nestedList) {
  stack = new Stack<NestedInteger>();
  for (int i = nestedList.size<>; i >= -; i--) {
    stack.push(nestedList.get(i));
  }
}

@Override
public Integer next() {
  return stack.pop().getInteger();
}

@Override 
public Integer hasNext() {
  while (!stack.isEmpty()) {
    if (stack.peek().isInteger()) {
      return true;
    } else {
      NestedInteger nestedInt = stack.pop();
      List<NestedInteger> list = nestedInt.getList();
      for (int i = list.size(); i >= 0; i--) {
        stack.push(list.get(i));
      }
    }
  }
  return false;
}
