class Solution {
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        N--;
        int index = 0; 
        
        while (N > 0) {
            if (index % 4 == 0) { 
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) { 
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) { 
                stack.push(N);
            } else { 
                stack.push(-N);
            }
            index++;
            N--;
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
