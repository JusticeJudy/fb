public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Integer> stack = new Stack<Integer>();
    int[] result = new int[n];
    int prevTime = -1;
    for (String log : logs) {
        String[] c = log.split(":");
        if (!stack.empty()) {
            // whichever function that is being run will pause, and we increment that function by the delta of
             // the prevTime and the new function's start or end time
            result[stack.peek()] += Integer.parseInt(c[2]) - prevTime;
        }
        prevTime = Integer.parseInt(c[2]);
        if (c[1].equals("start")) {
            // if function just starts, we push them into stack and let it "run"
            stack.push(Integer.parseInt(c[0]));
        } else {
            // if function is ending, we pop whatever function is running on the stack, and increment that function's
             // runtime, because the time spent calling this new function is included in this function's run time
            result[stack.pop()]++;
            prevTime++;
        }
    }
    return result;
}
