class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) {
                continue;                       // skip empty & current-dir
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pollLast();  // go up
            } else {
                stack.offerLast(part);          // real directory
            }
        }
        return "/" + String.join("/", stack);
    }
}