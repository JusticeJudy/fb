public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Integer> stack = new Stack<Integer>();
    int[] result = new int[n];
    int prevTime = -1;
    for (String log : logs) {
        String[] c = log.split(":");
        if (!stack.empty()) {
            result[stack.peek()] += Integer.parseInt(c[2]) - prevTime;
        }
        prevTime = Integer.parseInt(c[2]);
        if (c[1].equals("start")) {
            stack.push(Integer.parseInt(c[0]));
        } else {
            result[stack.pop()]++;
            prevTime++;
        }
    }
    return result;
}
